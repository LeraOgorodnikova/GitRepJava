/**
 * Created by 1 on 14.09.2016.
 */
public class lab3_ex5 {
    public static void Compare(float a, float b){
        int i1 = Float.floatToIntBits(a);
        int i2 = Float.floatToIntBits(b);
        System.out.println("a==b: "+(i1 == i2));
    }
    public static void main(String args[]) {
        float a = -0.0f;
        float b = 0.0f;
        Compare(a,b);
    }
}
