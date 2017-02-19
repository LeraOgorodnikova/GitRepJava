
public class DisjointSet {

    private int[] array;

    public DisjointSet(){
        array=new int[8];
        array[0]=0;
        array[1]=1;
        array[2]=2;
        array[3]=2;
        array[4]=1;
        array[5]=1;
        array[6]=2;
        array[7]=2;
    }

//    public void make (int v) {
//        array[v] = v;
//    }

    public int find_parent(int v){
        if (v == array[v])
            return v;
        return array[v] = find_parent(array[v]);
    }

    public boolean find(int a, int b){

        if (find_parent(a)==find_parent(b)){
            return true;
        }else{
            return false;
        }
    }

    public void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);
        if (a != b)
            array[b] = a;
    }
}
