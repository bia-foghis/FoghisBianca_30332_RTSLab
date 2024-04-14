package LabSession3.app2;

public class Main {
    public static void main(String[] args) {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(1);
        new ExecutionThread(monitor1, monitor2,4, 2, 4, 4, 6).start();
        new ExecutionThread(monitor1, monitor2, 5, 3, 5, 5, 7).start();
    }
}
