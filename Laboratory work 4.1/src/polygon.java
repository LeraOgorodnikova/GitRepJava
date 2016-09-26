/**
 * Created by 1 on 26.09.2016.
 */
import java.util.ArrayList;
import java.math.*;
public class polygon {
    ArrayList listPoint;
    polygon(int lenght){
        listPoint=new ArrayList(lenght);
    }
    public void addPoint(point newPoint){
        listPoint.add(newPoint);
    }
    public point takePoint(int index){
        return (point)listPoint.get(index-1);
    }
    /*public void increaseMassiv(int lenght){
        point[] massiv1=new point[massivPoint.length];
        for (int i=0;i>massivPoint.length;i++){
            massiv1[i]=massivPoint[i];
        }
        massivPoint=null;
        massivPoint=new point[lenght];
        for (int i=0;i<massiv1.length;i++){
            massivPoint[i]=massiv1[i];
        }
    }*/
    public ArrayList findPoints(point newPoint){
        ArrayList points=new ArrayList();
        for (int i=0;i<listPoint.size();i++){
            point p1=(point)listPoint.get(i);
            if ((p1.getX()==newPoint.getX())&&(p1.getY()==newPoint.getY())){
                points.add(p1);
            }
        }
        return points;
    }
    public String InfoPoints(){
        String out="";
        for (int i=0;i< listPoint.size();i++){
            point p1=(point)listPoint.get(i);
            out += String.format("%.2f",p1.getX());
            out += ":";
            out += String.format("%.3f", p1.getY());
            out += "-";
        }
        return out;
    }
    public float lenghtPolygon(){
        float lenght=0f;
        for (int i=1;i<listPoint.size();i++){
            point p1=(point)listPoint.get(i);
            point p2=(point)listPoint.get(i-1);
            lenght+=Math.sqrt(Math.abs(Math.pow((p1.getX()-p2.getX()), 2)) + Math.abs(Math.pow((p1.getY() - p2.getY()),2)));
        }
        return lenght;
    }
}
