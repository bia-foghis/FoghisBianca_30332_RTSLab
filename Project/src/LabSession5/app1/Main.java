package LabSession5.app1;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.BrokenBarrierException;

public class Main {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException{
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All threads have reached the barrier!");
            }
        });

        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);

        while(true){
            new ExecutionThread(barrier, s1, s2, 4,2, 4, 4, 6).start();
            new ExecutionThread(barrier, s2, s1, 5, 3, 5, 5 ,7).start();
            barrier.await();
            barrier.reset();
        }
    }
}
