package Part1;

import java.util.Scanner;

public class Controller extends Thread{
    protected boolean stop = false;
    protected Robot robot;
    PlaceHandler placeHandler = new PlaceHandler();
    Supervisor supervisor;

    Transition_t_1_Controller t_1_controller;
    Transition_t_2_Controller t_2_controller;
    Transition_t_o2_Controller t_o2_controller;
    Transition_t_o1_Controller t_o1_controller;

    Scanner in = new Scanner(System.in);

    @Override
    public void run() {
        placeHandler.AddPlace(new IntPlace("p_i1", null));
        placeHandler.AddPlace(new IntPlace("p_1", 0));
        placeHandler.AddPlace(new IntPlace("p_o1", null));
        placeHandler.AddPlace(new IntPlace("p_2", null));
        placeHandler.AddPlace(new IntPlace("p_i2", null));

        t_1_controller = new Transition_t_1_Controller("t_1", placeHandler, 0);
        t_2_controller = new Transition_t_2_Controller("t_2", placeHandler, 0);
        t_o2_controller = new Transition_t_o2_Controller("t_o2", placeHandler, 0);
        t_o2_controller.robotPlaceHandler = robot.placeHandler;
        t_o1_controller = new Transition_t_o1_Controller("t_o1", placeHandler, 0);
        t_o1_controller.supervisorPlaceHandler = supervisor.placeHandler;


        while(!stop){
            t_1_controller.TransitionGuardsMappings();
            t_2_controller.TransitionGuardsMappings();
            t_o2_controller.TransitionGuardsMappings();
            t_o1_controller.TransitionGuardsMappings();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
