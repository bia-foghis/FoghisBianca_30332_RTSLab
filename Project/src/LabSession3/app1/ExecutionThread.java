package LabSession3.app1;

public class ExecutionThread extends Thread{
    Integer monitor1, monitor2;
    int sleep_time, activity_min, activity_max;
    public ExecutionThread(Integer monitor1, Integer monitor2, int sleep_time, int activity_min, int activity_max) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep_time = sleep_time;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        if (monitor1 != null && monitor2 != null) {
            synchronized (monitor1) {
                synchronized (monitor2) {
                    System.out.println(this.getName() + " - STATE 2");

                    int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                    for (int i = 0; i < k * 100000; i++) {
                        i++;
                        i--;
                    }

                    try {
                        Thread.sleep(sleep_time*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (monitor1 != null)
        {
            synchronized (monitor1) {
                System.out.println(this.getName() + " - STATE 2");

                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                try {
                    Thread.sleep(sleep_time*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (monitor2 != null)
        {
            synchronized (monitor2) {
                System.out.println(this.getName() + " - STATE 2");

                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                try {
                    Thread.sleep(sleep_time*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(this.getName() + " - STATE 3");
    }
}
