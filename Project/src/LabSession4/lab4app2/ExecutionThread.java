package LabSession4.lab4app2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutionThread extends Thread{
    Lock l1, l2;
    int sleep_time, activity1_min, activity1_max, activity2_min, activity2_max;

    public ExecutionThread(Lock l1, Lock l2, int sleep_time, int activity1_min, int activity1_max, int activity2_min, int activity2_max) {
        this.l1 = l1;
        this.l2 = l2;
        this.sleep_time = sleep_time;
        this.activity1_min = activity1_min;
        this.activity1_max = activity1_max;
        this.activity2_min = activity2_min;
        this.activity2_max = activity2_max;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity1_max - activity1_min) + activity1_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        if (this.l1.tryLock()) {
            try {
                System.out.println(this.getName() + " acquired the lock l1");

                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random() * (activity2_max - activity2_min) + activity2_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                if (this.l2.tryLock()) {
                    try {
                        System.out.println(this.getName() + " acquired the lock l2");

                        System.out.println(this.getName() + " - STATE 3");
                        try {
                            Thread.sleep(sleep_time * 1000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } finally {
                        this.l2.unlock();
                        System.out.println(this.getName() + " released the lock l2");
                        System.out.println(this.getName() + " - STATE 4");
                    }
                } else {
                    System.out.println(this.getName() + " failed to acquire lock l2, skipping critical section");
                }
            } finally {
                this.l1.unlock();
                System.out.println(this.getName() + " released the lock l1");
            }
        } else {
            System.out.println(this.getName() + " failed to acquire lock l1, skipping critical section");
        }
    }
}
