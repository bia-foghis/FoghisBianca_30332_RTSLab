package LabSession5.app2;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class ExecutionThread extends Thread{
    Lock l1;
    CountDownLatch c;
    int sleep_time, activity_min, activity_max;
    public ExecutionThread(Lock l1, CountDownLatch c,int sleep_time, int activity_min, int activity_max) {
        this.l1 = l1;
        this.c = c;
        this.sleep_time = sleep_time;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
        while(true) {
            System.out.println(this.getName() + " - STATE 1");
            this.l1.lock();

            System.out.println(this.getName() + " - STATE 2");

            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }

            try {
                Thread.sleep(Math.round(Math.random() * this.sleep_time * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.l1.unlock();
            System.out.println(this.getName() + " - STATE 3");

            c.countDown();
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
