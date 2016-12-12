import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex8Lucky {

    static int[] x = {0};
    static int[] count = {0};
     static int xCount=0;
    //static int[] array = {0,0};

    static class LuckyThread extends Thread {
        @Override
        public  void run() {
                while (x[0] < 999999) {

                    synchronized (x) {
                        x[0]++;
                        xCount = x[0];
                    }
                    if ((xCount % 10) + (xCount / 10) % 10 + (xCount / 100) % 10 ==
                            (xCount / 1000) % 10 + (xCount / 10000) % 10 + (xCount / 100000) % 10) {
                        System.out.println(xCount);

                        synchronized (count) {
                            count[0]++;
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
        System.out.println("Total: " + count[0]);
    }
}
