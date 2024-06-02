package Part1;

import LabSession6.Part1.Interfaces.IPlaceHandler;
import LabSession6.Part1.Interfaces.ITransition;

import java.util.List;

public class Transition_t_s2_Supervisor implements ITransition {
    String name;
    Integer eet;
    Integer let;
    Integer timeUnitControl = 500;
    IPlaceHandler placeHandler;

    IPlaceHandler controllerPlaceHandler;

    public Transition_t_s2_Supervisor(String name, IPlaceHandler placeHandler, Integer delay){
        this.Init(name, placeHandler);
        this.SetDelay(delay);
    }


    @Override
    public void Init(String name, IPlaceHandler placeHandler) {
        this.name = name;
        this.placeHandler = placeHandler;
    }

    @Override
    public void SetDelay(int value) {
        this.eet = value;
    }

    @Override
    public void SetDelayInRange(int eet, int let) {
        this.eet = eet;
        this.let = let;
    }

    @Override
    public void TransitionDelay() {
        try {
            if(let == null){
                Thread.sleep(this.eet * timeUnitControl);
            } else {
                Thread.sleep(Math.round(Math.random()*(this.let - this.eet)+this.eet)*timeUnitControl);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Supervisor--------------\n";

        List<UserMove> listOfUserMoves = (List<UserMove>) placeHandler.GetPlaceByName("ps_1").Get();

        if(!listOfUserMoves.isEmpty() && !placeHandler.GetPlaceByName("ps_2").IsNull() && (listOfUserMoves.get(0).r != placeHandler.GetPlaceByName("ps_2").Get())){
            toPrint = toPrint.concat(Print() + "\n");

            placeHandler.GetPlaceByName("ps_o1").Set(listOfUserMoves.get(0).r);
            controllerPlaceHandler.GetPlaceByName("p_i1").Set(placeHandler.GetPlaceByName("ps_o1").Get());
            placeHandler.GetPlaceByName("ps_3").Set(listOfUserMoves.get(0).e);
            listOfUserMoves.remove(0);

            toPrint = toPrint.concat(Print() + "\n");
            toPrint = toPrint.concat("--------------------------------------\n");

            System.out.println(toPrint);
            return true;
        }
        return false;
    }

    @Override
    public String Print() {
        return this.name + "\n" + this.placeHandler.PrintAllPlaces();
    }
}
