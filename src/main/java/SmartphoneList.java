import java.util.ArrayList;
import java.util.List;

public class SmartphoneList {
    private static  List<Smartphone> smartphoneList=new ArrayList();
    private SmartphoneList(){
    }

    static{
        smartphoneList.add(new Smartphone(1,"iphone","Smartphone1",10,2500,8,"M64x","Android 4"));
        smartphoneList.add(new Smartphone(2,"samsung","Smartphone2",5.5,5500,5,"M32x","Android 6"));
        smartphoneList.add(new Smartphone(3,"xiaomi","Smartphone3",11,2700,2,"A64x","Android 7"));
        smartphoneList.add(new Smartphone(4,"samsung","Smartphone4",7,6500,4,"SS64x","Android 10"));
        smartphoneList.add(new Smartphone(5,"iphone","Smartphone5",4,10000,2,"SS64x","Android 4"));
    }

    public static List<Smartphone> getInstance(){
        return smartphoneList;
    }

}
