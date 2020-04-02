import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SmartphoneService {

    List <Smartphone> sPhoneList=SmartphoneList.getInstance();

    public List <Smartphone> getAllSmartphones(){
        return sPhoneList;
    }
    public List <Smartphone> getListByModel(String model){
        List <Smartphone> sPhbyModel=new ArrayList<Smartphone>();
        for(Smartphone sphone:sPhoneList){
            if(sphone.getModel().equals(model)) sPhbyModel.add(sphone);
        }
        return sPhbyModel;
    }
    public List <Smartphone> getListByPrice(double minPrice,double maxPrice){
        List <Smartphone> sPhbyPrice=new ArrayList<Smartphone>();
        for(Smartphone sphone:sPhoneList){
            if(sphone.getPrice()>=minPrice&&sphone.getPrice()<=maxPrice) sPhbyPrice.add(sphone);
        }
        return sPhbyPrice;
    }
    public boolean add(Smartphone smart){
        int id=smart.getId();
        for(Smartphone s:sPhoneList){
            if(s.getId()==id)return false;
        }
        sPhoneList.add(smart);
        return true;
    }

    public boolean edit(Smartphone smart){
        int id=smart.getId();
        for(Smartphone s:sPhoneList){
            if(s.getId()==id){int i=sPhoneList.indexOf(s);sPhoneList.remove(s);sPhoneList.add(i,smart);return true;}
        }
        return false;
    }

    public boolean del(int id){
        for(Smartphone s:sPhoneList){
            if(s.getId()==id){sPhoneList.remove(s);return true;}
        }
        return false;
    }

    public Smartphone getSmartphoneById(long id) {
        for(Smartphone s:sPhoneList){
            if(s.getId()==id){return s;}
        }
        return null;
    }
}
