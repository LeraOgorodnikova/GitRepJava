import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex8Lucky {

    static int x = 0;
    static int count = 0;
    static private Lock lock = new ReentrantLock();


    static class LuckyThread extends Thread {
        @Override
        public void run() {

            //необходима синхронизация
            //снарухи while не ставить синхронайз
            //блокировать ресурсы по мере их надобности
            try{
            if(lock.tryLock(1, TimeUnit.SECONDS)) {
                while (x < 999999) {
                    x++;
                    if ((x % 10) + (x / 10) % 10 + (x / 100) % 10 == (x / 1000)
                            % 10 + (x / 10000) % 10 + (x / 100000) % 10) {
                        System.out.println(x);
                        count++;
                    }
                }
            }
            }catch(InterruptedException e){}
            finally{
                //убираем лок
                lock.unlock();
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
        System.out.println("Total: " + count);
    }
}
