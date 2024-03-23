package LabSession2.example3;

public class JoinTestThread extends Thread {
    Thread t;
    public String n;
    public int number;
    public int sum;

    JoinTestThread(String n, Thread t, int number){
        this.n = n;
        this.t = t;
        this.number = number;
    }

    public void run() {
        System.out.println("Thread "+n+" has entered the run() method");

        try {
            if (t != null) t.join();

            System.out.println("Thread "+n+" executing operation.");
            Thread.sleep(3000);
            System.out.println("Thread "+n+" has terminated operation.");

            for(int i = 1; i <= number; i++){
                if(number%i == 0){
                    sum += i;
                }
            }

            Main.sum += sum;

            System.out.println("Thread "+n+" has computed the sum: "+sum+".");
            Thread.sleep(3000);
            System.out.println("Thread "+n+" has terminated operation.");
            System.out.println("The total sum is: "+Main.sum+".");

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
