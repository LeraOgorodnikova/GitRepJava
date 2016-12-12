package Laba10_Philosopher;


import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable{

    int number;
    final Fork fork1;
    final Fork fork2;

    public Philosopher(int number, Fork fork1, Fork fork2) {
        this.number = number;
        this.fork1 = fork1;
        this.fork2 = fork2;
    }

    public void run() {
        while (true) {
            System.out.println("Philosopher " + number + " is thinking");
            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
            }

                System.out.println("Philosopher " + number + " starts eating");

                takeForks();

                try {
                    Thread.sleep((int) (Math.random() * 10));
                } catch (InterruptedException e) {
                }
                System.out.println("Philosopher " + number + " ends eating");

                putForks();
        }
    }

    // ######## Start Strategy #########
    static volatile ReentrantLock[] locks = new ReentrantLock[5];

    static {
        for (int i = 0; i < locks.length; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    void takeForks() {
        // TODO synchronize

        //synchronized (locks) {
            locks[fork1.number].lock();
            locks[fork2.number].lock();

            fork1.take(number);
            fork2.take(number);
        //}
    }

    void putForks() {
        // TODO synchronize

            fork1.put(number);
            fork2.put(number);

            locks[fork1.number].unlock();
            locks[fork2.number].unlock();
    }
}
