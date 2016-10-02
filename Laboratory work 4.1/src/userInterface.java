/**
 * Created by 1 on 26.09.2016.
 */
import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    private int numberPoint;
    private Polygon line;
    public void EqualPoint(Point newPoint){
        ArrayList points=line.findPoints(newPoint);
        for (int i=0;i<points.size();i++){
            Point tempPoint=(Point)points.get(i);
            System.out.println(tempPoint.getX()+","+tempPoint.getY()+"-");
        }
    }
    public void LenghtLine(){
        System.out.print("\nДлина линии: ");
        System.out.printf("%.2f", line.lenghtPolygon());
    }
    public void InfoLine(){
        System.out.print("Ваша линия: "+line.toString());
    }
    public Point addPoint(){
        Point newPoint=new Point();
        float x=0f,y=0f;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите x: ");
        if(sc.hasNextFloat()) { // возвращает истинну если с потока ввода можно считать целое число
            x=sc.nextInt();
        }
        System.out.print("Введите y: ");
        if(sc.hasNextFloat()) { // возвращает истинну если с потока ввода можно считать целое число
            y=sc.nextInt();
        }
        newPoint.readPoints(x,y);
        return newPoint;
    }
    public void setNumberPoint(){
        System.out.print("Хотите указать кол-во точек?1-да, 0-нет: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        if(sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
            choice=sc.nextInt();
            if (choice==1){
                System.out.print("Введите количество точек: ");
                if (sc.hasNextInt()){
                    int numberPoints=sc.nextInt();
                    line=new Polygon(numberPoints);
                }
            }
            else {
                line=new Polygon(15);
            }
        }
    }
    public void workWithUser(){
        int exit=0;
        Scanner sc = new Scanner(System.in);
        while (exit==0) {
            setNumberPoint();
            int choice = 1;
            while (choice==1){
                Point newPoint=addPoint();
                line.addPoint(newPoint);
                System.out.print("1-добавить еще точку, 0-больше не добавлять: ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                }
            }
            InfoLine();//
            LenghtLine();//
            System.out.print("\nЗадайте свою точку: ");
            Point newPoint=addPoint();
            System.out.print("Задать точку плоскости? 1-да, 0-нет ");
            int planePoinChoice=0;
            Point pointPlane=new Point();
            if (sc.hasNextInt()) {
                planePoinChoice = sc.nextInt();
                if (planePoinChoice==1) {
                    pointPlane = addPoint();
                }
            }
            System.out.print("Расстояние между вашей точкой и точкой плоскости: "+newPoint.calculateLenght(pointPlane));
            System.out.print("\n1- выйти из программы, 0-создать новую ломаную: ");
            if (sc.hasNextInt()) {
                exit= sc.nextInt();
            }
        }
    }
}
