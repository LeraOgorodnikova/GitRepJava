/**
 * Created by 1 on 26.09.2016.
 */
import java.util.ArrayList;

public class Polygon {
    private ArrayList <Point> listPoint;
    Polygon(int lenght){
        listPoint=new ArrayList(lenght);
    }
    public void addPoint(Point newPoint){
        listPoint.add(newPoint);
    }
    public Point takePoint(int index){
        return listPoint.get(index-1);
    }
    public ArrayList findPoints(Point newPoint){
        ArrayList points=new ArrayList();
        for (int i=0;i<listPoint.size();i++){
            Point p1=listPoint.get(i);
            if ((p1.getX()==newPoint.getX())&&(p1.getY()==newPoint.getY())){
                points.add(p1);
            }
        }
        return points;
    }
    public String toString(){
        String out="";
        for (int i=0;i< listPoint.size();i++){
            Point p1=listPoint.get(i);
            out +=p1.toString();
            out += "-";
        }
        return out;
    }
    public float lenght(){
        float lenght=0f;
        for (int i=1;i<listPoint.size();i++){
            Point p1=listPoint.get(i);
            Point p2=listPoint.get(i-1);
            lenght+=Math.sqrt(Math.abs(Math.pow((p1.getX()-p2.getX()), 2)) + Math.abs(Math.pow((p1.getY() - p2.getY()),2)));
        }
        return lenght;
    }
}
