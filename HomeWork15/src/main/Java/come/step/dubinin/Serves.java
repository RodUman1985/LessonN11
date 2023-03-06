package come.step.dubinin;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Serves {
   public static ArrayList<String> List2 = new ArrayList<>();
    public static String getUserScrol(String t) {
        if (t==null){
            if(List2.isEmpty()){
                return "Please choose youre weapon";
            }
        }else {
            List2.add(t);

        }
        StringBuffer sb = new StringBuffer("<ol>");
        for (String i : List2) {
            sb.append("<li>" + i + "</li>");
        }
        return sb.append("</ol>").toString();
    }


    public static BigDecimal Calc(String[] r) {
        BigDecimal it = BigDecimal.ZERO;
        for (String e : r) {
            String s = e.replaceAll("[\\D&&[^.]]", "");
            it = it.add(new BigDecimal(s));
        }
        return it;


    }
    public static String setScrol() {

        StringBuffer sb1 = new StringBuffer("<ol>");
        for (String i : List2) {
            sb1.append("<li>" + i + "</li>");
        }
        return sb1.append("</ol>").toString();
    }
}
