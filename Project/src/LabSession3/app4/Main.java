package LabSession3.app4;


public class Main {
    Integer monitor1 = new Integer(1);
    Integer monitor2 = new Integer(1);
    ThreadOne t1 = new ThreadOne(monitor1,monitor2,7,2,3);
    ExecutionThread t2 = new ExecutionThread(monitor2,0,3,5,t1);
    ExecutionThread t3 = new ExecutionThread(monitor1,0,4,6,t1);

    /*t1.start();
    t2.start();
    t3.start();*/
}
