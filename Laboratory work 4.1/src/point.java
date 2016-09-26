/**
 * Created by 1 on 26.09.2016.
 */
import java.util.Scanner;
public class point {
    private float x;
    private float y;
    point(){
        x=0f;
        y=0f;
    }
    public float calculateLenght(point newPoint){
        return (float)Math.sqrt(Math.abs(Math.pow((newPoint.getX()-this.getX()), 2)) + Math.abs(Math.pow((newPoint.getY() - this.getY()),2)));
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void movement(point newpoint){
        this.x=newpoint.getX();
        this.y=newpoint.getY();
    }
    public void readPoints(float x,float y){
        this.setX(x);
        this.setY(y);
    }
    public String printOut() {
        String out= String.format("%.3f",this.x);
        out += ":";
        out += String.format("%.3f",this.y);
        return out;
    }
    public boolean comparison(point com1,point com2){
        if ((com1.getX()==com2.getX())&&(com1.getY()==com2.getY())){
            return true;
        }
        else return false;
    }
}
