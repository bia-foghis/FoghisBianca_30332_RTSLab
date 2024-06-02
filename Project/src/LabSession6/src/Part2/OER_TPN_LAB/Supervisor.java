package Part2.OER_TPN_LAB;

import LabSession6.Part2.Components.*;
import LabSession6.Part2.DataObjects.DataInteger;
import LabSession6.Part2.DataObjects.DataREL;
import LabSession6.Part2.DataObjects.DataRELQueue;
import LabSession6.Part2.DataObjects.DataTransfer;
import LabSession6.Part2.DataOnly.TransferOperation;
import LabSession6.Part2.Enumerations.LogicConnector;
import LabSession6.Part2.Enumerations.TransitionCondition;
import LabSession6.Part2.Enumerations.TransitionOperation;

import java.util.ArrayList;

public class Supervisor {
    public static void main(String[] args) {
        PetriNet supervisor = new PetriNet();
        supervisor.PetriNetName = "Supervisor";
        supervisor.NetworkPort = 1082;

        DataREL ps_i1 = new DataREL();
        ps_i1.SetName("ps_i1");
        supervisor.PlaceList.add(ps_i1);

        DataRELQueue ps_1 = new DataRELQueue();
        ps_1.SetName("ps_1");
        supervisor.PlaceList.add(ps_1);

        DataInteger ps_2 = new DataInteger();
        ps_2.SetName("ps_2");
        ps_2.SetValue(0);
        supervisor.PlaceList.add(ps_2);

        DataInteger ps_3 = new DataInteger();
        ps_3.SetName("ps_3");
        ps_3.SetValue(0);
        supervisor.PlaceList.add(ps_3);

        DataInteger ps_i2 = new DataInteger();
        ps_i2.SetName("ps_i2");
        supervisor.PlaceList.add(ps_i2);

        DataTransfer ps_o1 = new DataTransfer();
        ps_o1.SetName("ps_o1");
        ps_o1.Value = new TransferOperation("localhost", "1080", "p_i1");
        supervisor.PlaceList.add(ps_o1);

        DataInteger ps_o2 = new DataInteger();
        ps_o2.SetName("ps_o2");
        supervisor.PlaceList.add(ps_o2);

//Ts_1
        PetriTransition ts_1 = new PetriTransition(supervisor);
        ts_1.SetName("ts_1");
        ts_1.InputPlaceName.add("ps_i1");

        Condition Ts1C1 = new Condition(ts_1, "ps_i1", TransitionCondition.NotNull);

        GuardMapping g1 = new GuardMapping();
        g1.condition = Ts1C1;

        g1.Activations.add(new Activation(ts_1, "ps_i1", TransitionOperation.AddElement, "ps_1"));

        ts_1.GuardMappingList.add(g1);

        ts_1.Delay = 0;
        supervisor.Transitions.add(ts_1);

//Ts_2
        PetriTransition ts_2 = new PetriTransition(supervisor);
        ts_2.SetName("ts_2");
        ts_2.InputPlaceName.add("ps_1");
        ts_2.InputPlaceName.add("ps_2");
        ts_2.InputPlaceName.add("ps_3");

        Condition Ts2C1 = new Condition(ts_2, "ps_1", TransitionCondition.HaveREL);
        Condition Ts2C2 = new Condition(ts_2, "ps_2", TransitionCondition.NotNull);

        Ts2C1.SetNextCondition(LogicConnector.AND, Ts2C2);

        GuardMapping g2 = new GuardMapping();
        g2.condition = Ts2C1;

        ArrayList<String> outputList = new ArrayList<>();
        outputList.add("ps_01");
        outputList.add("ps_3");

        g2.Activations.add(new Activation(ts_2, "ps_1", TransitionOperation.SendROverNetwork, "ps_o1"));
        g2.Activations.add(new Activation(ts_2, "ps_1", TransitionOperation.PopElement_R_E, outputList));

        ts_2.GuardMappingList.add(g2);

        ts_2.Delay = 0;
        supervisor.Transitions.add(ts_2);

//Ts3
        PetriTransition ts_3 = new PetriTransition(supervisor);
        ts_3.SetName("ts_3");
        ts_3.InputPlaceName.add("ps_i2");

        Condition Ts3C1 = new Condition(ts_3, "ps_i2", TransitionCondition.NotNull);

        GuardMapping g3 = new GuardMapping();
        g3.condition = Ts3C1;

        g3.Activations.add(new Activation(ts_3, "ps_i2", TransitionOperation.Move, "ps_2"));
        g3.Activations.add(new Activation(ts_3, "ps_i2", TransitionOperation.Move, "ps_o2"));

        ts_3.GuardMappingList.add(g3);
        ts_3.Delay = 0;
        supervisor.Transitions.add(ts_3);


        System.out.println("Exp1 started \n ------------------------------");
        supervisor.Delay = 3000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = supervisor;
        frame.setVisible(true);
    }
}
