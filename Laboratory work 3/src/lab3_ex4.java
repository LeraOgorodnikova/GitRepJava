/**
 * Created by 1 on 14.09.2016.
 */
public class lab3_ex4 {
        public static void Compare(float a, float b,int num){
            //для float лучше округлять до 6 знаков после запятой
            float sum=a+b;
            boolean flag=false;
            float c=0.7f;
            if ((Float.isNaN(a)==true)&&(Float.isNaN(b)==true)){//если одно и чисел "Nan"
                System.out.println("a==b: true");
                flag=true;
            }
            if (flag==false){//если -0.0 и +0.0
                int i1 = Float.floatToIntBits(a);
                int i2 = Float.floatToIntBits(b);
                System.out.println("a==b: "+(i1 == i2));
            }
        }
        public static void main(String args[]) {
            float a = 0.0f/0.0f;
            float b = 0.0f/0.0f;
            int num=6;
            Compare(a,b,num);
        }
}
