/**
 * Created by 1 on 14.09.2016.
 */
public class lab2_ex2 {
    public  void Calculator(String args[]) {

        int num1,num2;
        num1=Integer.parseInt(args[0]);
        num2=Integer.parseInt(args[2]);
        char sign=args[1].charAt(0);
        if (sign=='*'){
            System.out.println(num1*num2);
        }
        if (sign=='/'){
            System.out.println(num1/num2);
        }
        if (sign=='+'){
            System.out.println(num1+num2);
        }
        if (sign=='-'){
            System.out.println(num1-num2);
        }
        if (sign=='^'){
            System.out.println(num1^num2);
        }
    }
}
