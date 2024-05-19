package LabSession5.app3;
import java.util.concurrent.CountDownLatch;

public class ExecutionThread1 extends Thread{
    Integer monitor1, monitor2;
    CountDownLatch c;
    int sleep_time, activity_min, activity_max;

    public ExecutionThread1(Integer monitor1, Integer monitor2, CountDownLatch c, int sleep_time, int activity_min, int activity_max) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        synchronized (monitor1) {
            monitor1.notifyAll();
        }
        synchronized (monitor2) {
            monitor2.notifyAll();
        }

        System.out.println(this.getName() + " - STATE 3");
        this.c.countDown();
        try {
            this.c.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
