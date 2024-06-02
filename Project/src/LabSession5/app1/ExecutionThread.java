package LabSession5.app1;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;

public class ExecutionThread extends Thread{
    private CyclicBarrier barrier;
    private Semaphore s1, s2;
    int  sleep_time, activity1_min, activity1_max, activity2_min, activity2_max;

    public ExecutionThread(CyclicBarrier barrier, Semaphore s1, Semaphore s2, int sleep_time, int activity1_min, int activity1_max, int activity2_min, int activity2_max)
    {
        this.barrier = barrier;
        this.s1 = s1;
        this.s2 = s2;
        this.sleep_time = sleep_time;
        this.activity1_min = activity1_min;
        this.activity1_max = activity1_max;
        this.activity2_min = activity2_min;
        this.activity2_max = activity2_max;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        int k = (int) Math.round(Math.random() * (activity1_max - activity1_min) + activity1_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        try {
            this.s1.acquire(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.getName() + " - STATE 2");

        k = (int) Math.round(Math.random() * (activity2_max - activity2_min) + activity2_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        if (s2.tryAcquire(1)){
            try{
                System.out.println(this.getName() + " - STATE 3");

                try {
                    Thread.sleep(Math.round(Math.random() * this.sleep_time * 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            finally{
                s2.release(1);
            }
        }

        this.s1.release(1);

        System.out.println(this.getName() + " - STATE 4");

        try {
            this.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
