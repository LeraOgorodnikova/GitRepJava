/**
 * Created by 1 on 14.09.2016.
 */
import java.math.BigDecimal;
import java.text.DecimalFormat;
public class lab3_ex6 {
    public static void main(String args[]) {
        float sum=  500f;
        float percent=0.00000001f;
        float per=0f;
        for (int i=1;i<=12;i++){
            float add;
            add = sum * percent + per * percent;
            per += add;
        }
        sum +=per;
        System.out.println("Сумма на счете через год with float ");
        System.out.printf("%.50f",sum );



        BigDecimal sum2=new BigDecimal("500");
        BigDecimal percent2=new BigDecimal("0.00000001");
        for (int i=1;i<=12;i++) {
            BigDecimal pr=sum2.multiply(percent2);
            sum2 =sum2.add(pr);
        }
        ////////////////////////////////////
        String pattern = "##0.0000000000000000";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(sum2);
        System.out.println("\n Сумма на счете через год with BigDecimal "+  format);
    }
}
