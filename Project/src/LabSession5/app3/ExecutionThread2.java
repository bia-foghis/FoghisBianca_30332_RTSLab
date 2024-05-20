package LabSession5.app3;
import java.util.concurrent.CountDownLatch;

public class ExecutionThread2 extends Thread{
    Integer monitor1;
    CountDownLatch c;
    int sleep_time, activity_min, activity_max;
    public ExecutionThread2(Integer monitor1, CountDownLatch c, int sleep_time, int activity_min, int activity_max) {
        this.monitor1 = monitor1;
        this.c = c;
        this.sleep_time = sleep_time;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        try {
            Thread.sleep(Math.round(Math.random() * this.sleep_time * 500));
            synchronized (monitor1) {
                monitor1.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        System.out.println(this.getName() + " - STATE 3");
        c.countDown();
        try {
            c.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
