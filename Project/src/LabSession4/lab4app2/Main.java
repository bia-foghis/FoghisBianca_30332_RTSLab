package LabSession4.lab4app2;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();
        ExecutionThread t1 = new ExecutionThread(l1, l2, 4, 2, 4, 4, 6);
        ExecutionThread t2 = new ExecutionThread(l2, l1, 5, 3, 5, 5, 7);

        t1.start();
        t2.start();
    }
}
