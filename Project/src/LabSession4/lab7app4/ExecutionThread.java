package LabSession4.lab7app4;
import java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread{
    Semaphore s;
    int sleep_time, activity_min, activity_max;

    public ExecutionThread(Semaphore s, int sleep_time, int activity_min, int activity_max){
        this.s = s;
        this.sleep_time = sleep_time;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println(this.getName() + " - STATE 1");

                this.s.acquire(2);

                System.out.println(this.getName() + " - STATE 2");

                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                this.s.release(2);

                System.out.println(this.getName() + " - STATE 3");

                try {
                    Thread.sleep(sleep_time * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(this.getName() + " - STATE 4");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
