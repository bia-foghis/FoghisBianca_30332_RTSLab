package Part1;

public class Main {
    public static void main(String[] args) {
        Supervisor supervisor = new Supervisor();
        Controller controller = new Controller();
        Robot robot = new Robot();

        controller.robot = robot;
        controller.supervisor = supervisor;
        robot.controller = controller;
        supervisor.controller = controller;


        supervisor.start();
        controller.start();
        robot.start();
    }
}
