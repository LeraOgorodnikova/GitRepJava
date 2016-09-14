/**
 * Created by 1 on 14.09.2016.
 */
public class lab2_ex1 {
    public static void main(String args[]) {
        for (int i=0;i<args.length;i++){
            boolean flag=false;
            long number=Long.parseLong(args[i]);
            if ((number>=-128)&&(number <=127)){System.out.println(number + " - byte");flag=true;}
            if ((flag==false)&&(number>=-32768)&&(number <=32767)){System.out.println(number + " - short");flag=true;}
            if ((flag==false)&&(number>=-2147482648)&&(number <=2147483647)){System.out.println(number + " - int");flag=true;}
            if (flag==false){System.out.println(number + " - long");}
            flag=false;
        }
    }
}
