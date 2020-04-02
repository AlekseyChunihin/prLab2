import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(
        name = "SmartphoneServlet",
        urlPatterns = {"/smartphones"}
)
public class SmartphoneServlet extends HttpServlet {
    SmartphoneService smartphoneService = new SmartphoneService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("searchAction");
        if (action != null) {
            if ("getListByModel".equals(action)) {
                getListByModel(req, resp);
                return;
            }
            if ("getListByPrice".equals(action)) {
                getListByPrice(req, resp);
                return;
            }
        } else {
            List<Smartphone> result = smartphoneService.getAllSmartphones();
            forwardListSmartphone(req, resp, result);
        }

    }


    private void getListByModel(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String model = (req.getParameter("modelSmartphone"));
        List <Smartphone> smartphone = null;
        try {
            smartphone = smartphoneService.getListByModel(model);
        } catch (Exception ex) {
            Logger.getLogger(SmartphoneServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        forwardListSmartphone(req, resp, smartphone);
    }

    private void getListByPrice(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        double smartphonePriceMin=0;
        double smartphonePriceMax=1000000;
        String s=req.getParameter("priceSmartphone");
        String []price=s.split("-");
        if(price.length==2){
         smartphonePriceMin = Double.parseDouble(price[0]);
         smartphonePriceMax = Double.parseDouble(price[1]);
        }
        else smartphonePriceMax=Double.parseDouble(price[0]);
        if(smartphonePriceMax<smartphonePriceMin) {
            double tmp=smartphonePriceMax;
            smartphonePriceMax=smartphonePriceMin;
            smartphonePriceMin=tmp;
        }
        List<Smartphone> result = smartphoneService.getListByPrice(smartphonePriceMin,smartphonePriceMax);
        forwardListSmartphone(req, resp, result);
    }

    private void forwardListSmartphone(HttpServletRequest req, HttpServletResponse resp, List smartphonesList)
            throws ServletException, IOException {
        String nextJSP = "/list-smartphones.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("smartphoneList", smartphonesList);
        dispatcher.forward(req, resp);
    }
}