
/**
 * Created by 1 on 02.10.2016.
 */
public class Array {
  private Task[] tasks;
    private int sizeArray;
    Array(){
        sizeArray=1;
        tasks=new Task[sizeArray];
    }
    public Task[] getTasks() {
        return tasks;
    }

    public void increaseArray(){
        Task[] tempArray=tasks;
        tasks=new Task[sizeArray+1];
        sizeArray++;
        for (int i=0;i<tempArray.length;i++){
            tasks[i]=tempArray[i];
        }
    }
    public void addElem(Task newTask){
        tasks[sizeArray-1]=newTask;
        increaseArray();
    };  // добавление элемента кучи

    public Task getTaskWithHighestPriorityNotDelete(){
        Task result=new Task();
        result.setPriority(0);//убрать
        for (int i=0;i<sizeArray-1;i++){
            if (result.getPriority()<tasks[i].getPriority()){
                result=tasks[i];
            }
        }
        return result;
    }//получить задачу с наивысшим приоритетом из очереди (без ее удаления из очереди);

    public Task getTaskWithHighestPriorityWithDelete(){
        Task result=getTaskWithHighestPriorityNotDelete();
        deleteTask(result.getId());
        return result;
    }//извлечь задачу с наивысшим приоритетом из очереди c удалением;

    public Task getTaskWithHighestPriorityOfPoints(int points){
        Task[] selection=new Task[sizeArray];
        Task result=new Task();
        result.setPriority(0);
        int it=0;
        for (int i=0;i<sizeArray-1;i++){
            if (tasks[i].getPoints()<points){
                selection[it]=tasks[i];
                it++;
            }
        }
        for (int i=0;i<it;i++){
            if (result.getPriority()<selection[i].getPriority()){
                result=selection[i];
            }
        }
        return result;
    }//извлечь задачу с наивысшим приоритетом, трудоемкость которой не превышает заданное значение;

    public void deleteTask(int id){
        Task[] tempArray=new Task[sizeArray-1];
        int it=0;
        for (int i=0;i<sizeArray-1;i++){
            if (tasks[i].getId()!=id && tasks[i].getId()!=0){
                tempArray[it]=tasks[i];
                it++;}
        }
        sizeArray--;
        tasks=tempArray;
    }//удалить задачу по id

    public Task getTaskOfIdNotDelete(int id){
        Task result=new Task();
        for (int i=0;i<sizeArray-1;i++){
            if (tasks[i].getId()==id){
                result=tasks[i];
            }
        }
        return result;
    };//получить задачу по ее уникальному номеру из очереди (без ее удаления из очереди);

    public Task getTaskOfIdWithDelete(int id){
        Task result=getTaskOfIdNotDelete(id);
        deleteTask(id);
        return result;
    };//извлечь задачу по ее уникальному номеру из очереди;

    public void changePriority(int id, int priority){
        for (int i=0;i<sizeArray-1;i++){
            if (tasks[i].getId()==id){
                tasks[i].setPriority(priority);
            }
        }
    }//изменить приоритет задачи по ее уникальному номеру;

    public int getTotalPoints(){
        int total=0;
        for (int i=0;i<sizeArray-1;i++){
            total+=tasks[i].getPoints();
        }
        return total;
    };//вычислить суммарную трудоемкость задач, находящихся в очереди;

    public void clearQueue(){
        sizeArray=1;
        tasks=new Task[sizeArray];
    };//очистить очередь (удалить все задачи);

    public Task[] getQueue(){
        for (int i = 0; i < sizeArray-1; i++) {
            int minPriority = tasks[i].getPriority();
            int min_i = i;
            for (int j = i+1; j < sizeArray-1; j++) {
                //Если находим, запоминаем его индекс
                if (tasks[j].getPriority() < minPriority) {
                    minPriority = tasks[j].getPriority();
                    min_i = j;
                }
            }
            if (i != min_i) {
                Task tmp = tasks[i];
                tasks[i] = tasks[min_i];
                tasks[min_i] = tmp;
            }
        }
        return tasks;
    };// вернуть все содержимое очереди в виде массива задач, отсортированных по приоритетам.
}
