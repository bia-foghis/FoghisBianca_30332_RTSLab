package LabSession4.lab7app4;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        Semaphore s = new Semaphore(2);

        new ExecutionThread(s,5,3,6).start();
        new ExecutionThread(s,3,4,7).start();
        new ExecutionThread(s,6,5,7).start();
    }
}
