/**
 * Created by 1 on 02.10.2016.
 */
public class BinaryHeap {
    final int SIZE = 10; // максимальный размер кучи
    private Task[] heap;         // указатель на массив кучи
    private int heapSize; // размер кучи

    BinaryHeap(){
        heap = new Task[SIZE];
        heapSize = 0;
    };
    public void heapify(int i)//восстанавливает свой-во кучи
    {
        int leftChild;
        int rightChild;
        int largestChild;
        for (; ; )
        {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if (leftChild < heapSize && heap[leftChild].getPriority() > heap[largestChild].getPriority())
            {
                largestChild = leftChild;
            }

            if (rightChild < heapSize && heap[rightChild].getPriority() > heap[largestChild].getPriority())
            {
                largestChild = rightChild;
            }

            if (largestChild == i)
            {
                break;
            }

            Task temp = heap[i];
            heap[i] = heap[largestChild];
            heap[largestChild] = temp;
            i = largestChild;
        }
    }
    public void addElem(Task newTask){
        int i, parent;
        i = heapSize;
        heap[i] = newTask;
        parent = (i-1)/2;
        while((parent >= 0) && (i > 0))  {
            if(heap[i].getId() > heap[parent].getId()) {
                Task temp = heap[i];
                heap[i] = heap[parent];
                heap[parent] = temp;
            }
            i = parent;
            parent = (i-1)/2;
        }
        heapSize++;
    };  // добавление элемента кучи
    public Task getTaskWithHighestPriorityNotDelete(){
        return heap[0];
    }//получить задачу с наивысшим приоритетом из очереди (без ее удаления из очереди);
    public Task getTaskWithHighestPriorityWithDelete(){
        Task result=getTaskWithHighestPriorityNotDelete();
        deleteTask(result.getId());
        return result;
    }//извлечь задачу с наивысшим приоритетом из очереди c удалением;
    public Task getTaskWithHighestPriorityOfPoints(int points){
        Task[] selection=new Task[heapSize];
        Task result=new Task();
        result.setPriority(0);
        int it=0;
        for (int i=0;i<heapSize;i++){
            if (heap[i].getPoints()<points){
                selection[it]=heap[i];
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
        int num=0;
        for (int i=0;i<heapSize;i++){
            if (heap[i].getId()==id){
                num=i;
                break;
            }
        }
        heap[num]=heap[heapSize-1];
        heap[heapSize-1]=null;
        heapSize--;
        heapify(num);
    }//удалить задачу по id
    public Task getTaskOfIdNotDelete(int id){
        Task result=new Task();
        for (int i=0;i<heapSize;i++){
            if (heap[i].getId()==id){
                result = heap[i];
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
        Task result=new Task();
        for (int i=0;i<heapSize;i++){
            if (heap[i].getId()==id){
                heap[i].setPriority(priority);
            }
        }
    heapify(id);
    }//изменить приоритет задачи по ее уникальному номеру;
    public int getTotalPoints(){
        int total=0;
        for (int i=0;i<heapSize;i++){
            total+=heap[i].getPoints();
        }
        return total;
    };//вычислить суммарную трудоемкость задач, находящихся в очереди;
    public void clearQueue(){
        heap=new Task[SIZE];
        heapSize=0;
    };//очистить очередь (удалить все задачи);
    public Task[] getQueue(){
        return heap;
    };// вернуть все содержимое очереди в виде массива задач, отсортированных по приоритетам.
}
