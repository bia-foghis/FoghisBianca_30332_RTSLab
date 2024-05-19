package LabSession5.app3;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args){
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(1);

        CountDownLatch c = new CountDownLatch(3);

        new ExecutionThread1(monitor1, monitor2, c, 7, 2, 3).start();
        new ExecutionThread2(monitor1, c, 5, 3, 5).start();
        new ExecutionThread2(monitor2, c, 5, 4, 6).start();
    }
}
