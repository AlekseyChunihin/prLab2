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
        name = "SmartphoneEditServlet",
        urlPatterns = {"/edit"}
)
public class SmartphoneEditServlet extends HttpServlet {
    SmartphoneService smartphoneService = new SmartphoneService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                searchById(req, resp);

    }

    private void searchById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Integer.valueOf(req.getParameter("idSmartphone"));
        Smartphone smartphone = null;
        try {
            smartphone = smartphoneService.getSmartphoneById(id);
        } catch (Exception ex) {
            Logger.getLogger(SmartphoneEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("smartphone", smartphone);
        req.setAttribute("action", "edit");
        String nextJSP = "/new-smartphone.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addEmployeeAction(req, resp);
                break;
            case "edit":
                editEmployeeAction(req, resp);
                break;
            case "remove":
                removeEmployeeByName(req, resp);
                break;
        }

    }
    private void editEmployeeAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("idSmartphone"));
        String name = req.getParameter("name");
        String model = req.getParameter("model");
        double diagonal =Double.parseDouble(req.getParameter("diagonal"));
        double price=Double.parseDouble(req.getParameter("price"));
        int memory=Integer.parseInt(req.getParameter("memory"));
        String processor = req.getParameter("processor");
        String versionOS = req.getParameter("versionOS");
        Smartphone smartphone = new Smartphone(id,model,name,diagonal,price,memory,processor,versionOS);
        boolean isUpdated = smartphoneService.edit(smartphone);
        List<Smartphone> smartphoneList = smartphoneService.getAllSmartphones();
        String message ="";
        if(isUpdated)message="The employee has been successfully updated.";
        else message="Failure to update a smartphone.";
        req.setAttribute("message", message);
        req.setAttribute("success", isUpdated);
        forwardListSmartphone(req, resp, smartphoneList);
    }

    private void addEmployeeAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("idSmartphone"));
        String name = req.getParameter("name");
        String model = req.getParameter("model");
        double diagonal =Double.parseDouble(req.getParameter("diagonal"));
        int price=Integer.parseInt(req.getParameter("price"));
        int memory=Integer.parseInt(req.getParameter("memory"));
        String processor = req.getParameter("processor");
        String versionOS = req.getParameter("versionOS");

        Smartphone smartphone = new Smartphone(id,model,name,diagonal,price,memory,processor,versionOS);
        boolean isAdded = smartphoneService.add(smartphone);
        List<Smartphone> smartphoneList = smartphoneService.getAllSmartphones();
        String message ="";
        if(isAdded)message="The new smartphone has been successfully created.";
        else message="Failure to add a new smartphone.";
        req.setAttribute("message", message);
        req.setAttribute("success", isAdded);
        forwardListSmartphone(req, resp, smartphoneList);
    }

    private void removeEmployeeByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            int id =Integer.parseInt (req.getParameter("idSmartphone"));
            try {
                smartphoneService.del(id);
            } catch (Exception ex) {
                Logger.getLogger(SmartphoneEditServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            forwardListSmartphone(req, resp, smartphoneService.getAllSmartphones());

    }

    private void forwardListSmartphone(HttpServletRequest req, HttpServletResponse resp, List smartphonesList)
            throws ServletException, IOException {
        String nextJSP = "/list-smartphones.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("smartphoneList", smartphonesList);
        dispatcher.forward(req, resp);
    }
}