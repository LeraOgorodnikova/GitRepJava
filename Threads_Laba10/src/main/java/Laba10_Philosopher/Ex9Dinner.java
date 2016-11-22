package Laba10_Philosopher;



public class Ex9Dinner {

    public static void main(String[] args) throws InterruptedException {

        //почему зависает программа
        //jstack
        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i);
        }

        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % forks.length]);
        }

        for (int i = 0; i < philosophers.length; i++) {
            new Thread(philosophers[i]).start();
        }
    }
}
