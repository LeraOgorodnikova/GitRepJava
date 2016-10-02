/**
 * Created by 1 on 02.10.2016.
 */
import java.util.Scanner;
public class Main {
    public static Task inputTask(){
        Task newTask=new Task();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите уникальный номер: ");
        if(sc.hasNextInt()) {
            newTask.setId(sc.nextInt());
        }
        System.out.print("Введите приоритет: ");
        if(sc.hasNextInt()) {
            newTask.setPriority(sc.nextInt());
        }
        System.out.print("Введите трудоемкость: ");
        if(sc.hasNextInt()) {
            newTask.setPoints(sc.nextInt());
        }
        System.out.print("Введите текстовое описание: ");
        newTask.setDescription(sc.next());
        return newTask;
    }
    public static int requestId(){
        int id=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите уникальный номер: ");
        if(sc.hasNextInt()) {
            id=sc.nextInt();
        }
        return id;
    }
    public static void outTask(Task out){
        System.out.print("Id "+out.getId()+" Priority: "+out.getPriority()+" Points: "+ out.getPoints()+" Description: "+out.getDescription()+'\n');
    }
    public static void outQueue(Task[] out){
        for (int i=0;i<out.length;i++) {
            if (out[i] != null) {
                outTask(out[i]);
            }
        }
    }
    public static void main(String[] args){
        BinaryHeap binaryHeap=new BinaryHeap();
        Array array=new Array();
        int choice=1;
        while(choice!=0){
            Scanner sc = new Scanner(System.in);
            System.out.print("0 - выход из программы;\n" +
                            "1 − добавить задачу с приоритетом в очередь;\n" +
                            "2 − получить задачу с наивысшим приоритетом из очереди (без ее удаления из очереди);\n" +
                            "3 − извлечь задачу с наивысшим приоритетом из очереди;\n" +
                            "4 − извлечь задачу с наивысшим приоритетом, трудоемкость которой не превышает заданное значение;\n" +
                            "5 − удалить задачу по ее уникальному номеру из очереди;\n" +
                            "6 − получить задачу по ее уникальному номеру из очереди (без ее удаления из очереди);\n" +
                            "7 − извлечь задачу по ее уникальному номеру из очереди;\n" +
                            "8 − изменить приоритет задачи по ее уникальному номеру;\n" +
                            "9 − вычислить суммарную трудоемкость задач, находящихся в очереди;\n" +
                            "10 − очистить очередь (удалить все задачи);\n" +
                            "11 − вернуть все содержимое очереди в виде массива задач, отсортированных по приоритетам:  ");
            if(sc.hasNextInt()) {
                choice=sc.nextInt();
            }
            switch (choice){
                case 1:{
                    Task newTask=inputTask();
                    binaryHeap.addElem(newTask);
                    array.addElem(newTask);
                    System.out.print("DONE\n");
                    break;
                }
                case 2:{
                    System.out.print("задачa с наивысшим приоритетом BinaryHeap: ");
                    outTask(binaryHeap.getTaskWithHighestPriorityNotDelete());
                    System.out.print("задачa с наивысшим приоритетом Array: ");
                    outTask(array.getTaskWithHighestPriorityNotDelete());
                    break;
                }
                case 3:{
                    System.out.print("задачa с наивысшим приоритетом BinaryHeap: ");
                    outTask(binaryHeap.getTaskWithHighestPriorityWithDelete());
                    System.out.print("задачa с наивысшим приоритетом Array: ");
                    outTask(array.getTaskWithHighestPriorityWithDelete());
                    break;
                }
                case 4:{
                    int points=0;
                    System.out.print("Введите значение трудоемкости: ");
                    if(sc.hasNextInt()) {
                       points=sc.nextInt();
                    }
                    System.out.print("задачa с наивысшим приоритетом BinaryHeap: ");
                    outTask(binaryHeap.getTaskWithHighestPriorityOfPoints(points));
                    System.out.print("задачa с наивысшим приоритетом Array: ");
                    outTask(array.getTaskWithHighestPriorityOfPoints(points));
                    break;
                }
                case 5:{
                    int id=requestId();
                    binaryHeap.deleteTask(id);
                    array.deleteTask(id);
                    System.out.print("DONE\n");
                    break;
                }
                case 6:{
                    int id=requestId();
                    System.out.print("задачa по уникальному номеру BinaryHeap: ");
                    outTask(binaryHeap.getTaskOfIdNotDelete(id));
                    System.out.print("задачa по уникальному номеру Array: " );
                    outTask(array.getTaskOfIdNotDelete(id));
                    break;
                }
                case 7:{
                    int id=requestId();
                    System.out.print("задачa по уникальному номеру BinaryHeap: ");
                    outTask(binaryHeap.getTaskOfIdWithDelete(id));
                    System.out.print("задачa по уникальному номеру Array: ");
                    outTask(array.getTaskOfIdWithDelete(id));
                    break;
                }
                case 8:{
                    int id=requestId();
                    int priority=0;
                    System.out.print("Введите новое значение приоритета: ");
                    if(sc.hasNextInt()) {
                        priority=sc.nextInt();
                    }
                    binaryHeap.changePriority(id,priority);
                    array.changePriority(id,priority);
                    System.out.print("DONE\n");
                    break;
                }
                case 9:{
                    System.out.print("суммарная трудоемкость из BinaryHeap: "+binaryHeap.getTotalPoints());
                    System.out.print("суммарная трудоемкость из Array: "+array.getTotalPoints());
                    break;
                }
                case 10:{
                    binaryHeap.clearQueue();
                    array.clearQueue();
                    System.out.print("DONE\n");
                    break;
                }
                case 11:{
                    Task[] out=binaryHeap.getQueue();
                    System.out.print("BinaryHeap: ");
                    outQueue(out);
                    out=binaryHeap.getQueue();
                    System.out.print("Array: ");
                    outQueue(out);
                }
            }

        }
    }
}
