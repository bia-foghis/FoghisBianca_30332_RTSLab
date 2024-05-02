package LabSession3.app4;

public class ExecutionThread extends Thread{
    Integer monitor;
    int sleep_time, activity_min, activity_max;
    ThreadOne t1;

    public ExecutionThread(Integer monitor, int sleep_time, int activity_min, int activity_max, ThreadOne t1){
        this.monitor = monitor;
        this.sleep_time = sleep_time;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.t1 = t1;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        System.out.println(this.getName() + " - STATE 3");
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
