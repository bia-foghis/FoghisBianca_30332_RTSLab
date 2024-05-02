package LabSession3.app4;

public class ThreadOne extends Thread{
    Integer monitor1, monitor2;
    int sleep_time, activity_min, activity_max;

    public ThreadOne(Integer monitor1, Integer monitor2, int sleep_time, int activity_min, int activity_max){
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep_time = sleep_time;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        try {
            Thread.sleep(sleep_time*1000);
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
    }
}
