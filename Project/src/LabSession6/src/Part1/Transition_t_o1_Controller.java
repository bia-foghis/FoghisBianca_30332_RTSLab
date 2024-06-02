package Part1;

import LabSession6.Part1.Interfaces.IPlaceHandler;
import LabSession6.Part1.Interfaces.ITransition;

public class Transition_t_o1_Controller implements ITransition {
    String name;
    Integer eet;
    Integer let;
    Integer timeUnitControl = 500;
    IPlaceHandler placeHandler;
    IPlaceHandler supervisorPlaceHandler;

    public Transition_t_o1_Controller(String name, IPlaceHandler placeHandler, Integer delay){
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
        try{
            if(let == null){
                Thread.sleep(this.eet * timeUnitControl);
            } else {
                Thread.sleep(Math.round(Math.random()*(this.let - this.eet)+this.eet)*timeUnitControl);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Controller--------------\n";

        if(!placeHandler.GetPlaceByName("p_o1").IsNull()){
            toPrint = toPrint.concat(Print() + "\n");

            supervisorPlaceHandler.GetPlaceByName("ps_i2").Set(placeHandler.GetPlaceByName("p_o1").Get());
            placeHandler.GetPlaceByName("p_o1").Set(null);

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
