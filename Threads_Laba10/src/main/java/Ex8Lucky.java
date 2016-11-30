import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex8Lucky {

   // static int[] x = {0};
    //static int[] count = {0};

    static int[] array = {0,0};

    static class LuckyThread extends Thread {
        @Override
        public  void run() {

                while (array[0] < 999999) {
                    synchronized (array) {
                    array[0]++;
                    if ((array[0] % 10) + (array[0] / 10) % 10 + (array[0] / 100) % 10 == (array[0] / 1000) % 10 + (array[0] / 10000) % 10 + (array[0] / 100000) % 10) {
                        System.out.println(array[0]);
                        array[1]++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LuckyThread();
        Thread t2 = new LuckyThread();
        Thread t3 = new LuckyThread();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + array[1]);
    }
}
