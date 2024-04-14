package LabSession3.app2;

public class ExecutionThread extends Thread{
    Integer monitor1, monitor2;
    int sleep_time, activity1_min, activity1_max, activity2_min, activity2_max;
    public ExecutionThread(Integer monitor1, Integer monitor2, int sleep_time, int activity1_min, int activity1_max, int activity2_min, int activity2_max) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep_time = sleep_time;
        this.activity1_min = activity1_min;
        this.activity1_max = activity1_max;
        this.activity2_min = activity2_min;
        this.activity2_max = activity2_max;
    }
    public void run() {
        int k = (int) Math.round(Math.random() * (activity1_max - activity1_min) + activity1_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        System.out.println(this.getName() + " - STATE 1");

        synchronized (monitor1) {
            k = (int) Math.round(Math.random() * (activity2_max - activity2_min) + activity2_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }

            System.out.println(this.getName() + " - STATE 2");
        }

        synchronized (monitor2) {
            System.out.println(this.getName() + " - STATE 3");

            try {
                Thread.sleep(sleep_time*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(this.getName() + " - STATE 4");
    }
}
