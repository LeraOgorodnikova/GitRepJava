/**
 * Created by 1 on 14.09.2016.
 */
public class lab2_ex3 {
    public void NumberSystem(String[] args) {
	/* write your code */
        int radixFrom,radixIn;
        radixFrom=Integer.parseInt(args[1]);
        radixIn=Integer.parseInt(args[2]);
        System.out.println(args[0] + '('+radixFrom+')');

        int num10=Integer.parseInt(args[0],radixFrom);
        System.out.println(num10 + "(10)");

        int value = num10;
        String result = "";
        String alph="";
        while ( value %  radixIn > 0 ) {
            int p = value / radixIn;
            int q = value %  radixIn;
            switch (q){
                case 10:{alph="A";result = alph + result;}
                case 11:{alph="B";result = alph + result;}
                case 12:{alph="C";result = alph + result;}
                case 13:{alph="D";result = alph + result;}
                case 14:{alph="E";result = alph + result;}
                case 15:{alph="F";result = alph + result;}
                default:result = q + result;
            }
            alph="";
            value = p;
        }
        System.out.println(result +'('+ radixIn +')' );
    }
}
