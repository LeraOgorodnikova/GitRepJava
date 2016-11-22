package Laba10_Philosopher;



public class Fork {

    int number;

    public Fork(int number) {
        this.number = number;
    }

    volatile int philosopher = -1;

    public void take(int philosopher) {
        if (this.philosopher != -1) {
            System.out.println("Error: philosopher " + philosopher + " cannot take fork " + number + " because it's taken by philosopher " + this.philosopher);
            System.exit(1);
        }
        this.philosopher = philosopher;
        System.out.println("Philosopher " + philosopher + " take fork " + number);
    }

    public void put(int philosopher) {
        if (this.philosopher == -1) {
            System.out.println("Error: philosopher " + philosopher + " cannot put fork " + number + " because it's not taken");
            System.exit(1);
        }
        if (this.philosopher != philosopher) {
            System.out.println("Error: philosopher " + philosopher + " cannot put fork " + number + " because it's taken by philosopher " + this.philosopher);
            System.exit(1);
        }
        this.philosopher = -1;
        System.out.println("Philosopher " + philosopher + " put fork " + number);
    }
}
