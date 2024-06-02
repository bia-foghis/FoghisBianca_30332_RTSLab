package Part1;

import LabSession6.Part1.Interfaces.IPlaceHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class Supervisor extends Thread{
    boolean isStop = false;
    PlaceHandler placeHandler = new PlaceHandler();

    Controller controller;

    Transition_t_s1_Supervisor t_s1_supervisor;
    Transition_t_s2_Supervisor t_s2_supervisor;
    Transition_t_s3_Supervisor t_s3_supervisor;

    Scanner in = new Scanner(System.in);

    @Override
    public void run() {
        placeHandler.AddPlace(new UserPlace("ps_i1", null));
        placeHandler.AddPlace(new ListUserPlace("ps_1", new ArrayList<UserMove>()));
        placeHandler.AddPlace(new IntPlace("ps_2", 0));
        placeHandler.AddPlace(new IntPlace("ps_o1", null));
        placeHandler.AddPlace(new IntPlace("ps_3", 0));
        placeHandler.AddPlace(new IntPlace("ps_i2", null));
        placeHandler.AddPlace(new IntPlace("ps_o2", null));

        t_s1_supervisor = new Transition_t_s1_Supervisor("t_s1", placeHandler, 0);
        t_s2_supervisor = new Transition_t_s2_Supervisor("t_s2", placeHandler, 0);
        t_s2_supervisor.controllerPlaceHandler = controller.placeHandler;
        t_s3_supervisor = new Transition_t_s3_Supervisor("t_s3", placeHandler, 0);

        System.out.println("Supervisor: Input ps_i1.r:");
        Integer r = in.nextInt();
        System.out.println("Supervisor: Input ps_i1.e:");
        Integer e = in.nextInt();
        System.out.println("Supervisor: Input ps_i1.l:");
        Integer l = in.nextInt();

        UserMove input = new UserMove(r, e, l);
        this.placeHandler.GetPlaceByName("ps_i1").Set(input);

        while(!isStop){
            t_s1_supervisor.TransitionGuardsMappings();
            t_s2_supervisor.TransitionGuardsMappings();
            t_s3_supervisor.TransitionGuardsMappings();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
