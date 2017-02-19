
public class Main {

    public static void main(String[] args) {

        DisjointSet example=new DisjointSet();
        System.out.print("find(0,1): ");
        System.out.print(example.find(0,1));
        System.out.print("\n");

        System.out.print("find(6,3): ");
        System.out.print(example.find(6,3));
        System.out.print("\n");

        System.out.print("union(2,5)");
        example.union(2,5);
        System.out.print("\n");

        System.out.print("find(4,6): ");
        System.out.print(example.find(4,6));
        System.out.print("\n");

        System.out.print("find(0,6): ");
        System.out.print(example.find(0,6));
        System.out.print("\n");
    }
}
