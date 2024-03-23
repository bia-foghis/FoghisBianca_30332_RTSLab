package LabSession2.example5;


public class Main {
    public static void main(String args[]) {

        ReadThread rt = new ReadThread();
        WriteThread wt = new WriteThread();

        try{
            rt.conect(wt.getPipe());
            rt.start();wt.start();
        }catch(Exception e){e.printStackTrace();}
    }
}
