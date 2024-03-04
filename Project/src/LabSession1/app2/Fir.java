package LabSession1.app2;

import java.util.Observable;

public class Fir extends Observable implements Runnable {
    int id;
    Window win;
    int processorLoad;
    Thread t;

    Fir(int id,int priority,Window win, int procLoad){
        this.id = id;
        this.win = win;
        this.processorLoad = procLoad;
        t.setPriority(priority);
    }

    public int getId(){
        return id;
    }

    public int getProcessorLoad(){
        return processorLoad;
    }

    public void start(){
        if(t == null){
            t = new Thread(this);
            t.start();
        }
    }

    public void run(){
        int c = 0;

        while(c < 1000){
            for(int j = 0; j < this.processorLoad; j++){
                j++;
                j--;
            }
            c++;

            this.win.setProgressValue(id, c);
            this.setChanged();
            this.notifyObservers();
        }
    }
}
