package Part1;

public class Robot extends Thread{
    boolean isStop = false;
    PlaceHandler placeHandler = new PlaceHandler();
    Controller controller;


    Transition_t_1_Robot t_1_robot;
    Transition_t_2_Robot t_2_robot;

    @Override
    public void run() {
        placeHandler.AddPlace(new IntPlace("p_0", 0));
        placeHandler.AddPlace(new IntPlace("p_i", null));
        placeHandler.AddPlace(new IntPlace("p_1", null));
        placeHandler.AddPlace(new IntPlace("p_o", null));

        t_1_robot = new Transition_t_1_Robot("t_1", placeHandler, 0);
        t_2_robot = new Transition_t_2_Robot("t_2", placeHandler, 5);
        t_2_robot.controllerPlaceHandler = controller.placeHandler;

        while (!isStop){
            t_1_robot.TransitionGuardsMappings();
            t_2_robot.TransitionGuardsMappings();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
