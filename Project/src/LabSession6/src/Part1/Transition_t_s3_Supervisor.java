package Part1;

import LabSession6.Part1.Interfaces.IPlace;
import LabSession6.Part1.Interfaces.IPlaceHandler;
import LabSession6.Part1.Interfaces.ITransition;

public class Transition_t_s3_Supervisor implements ITransition {
    String name;
    Integer eet;
    Integer let;
    Integer timeUnitControl = 500;
    IPlaceHandler placeHandler;

    public Transition_t_s3_Supervisor(String name, IPlaceHandler placeHandler, Integer delay){
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
                Thread.sleep(this.eet*timeUnitControl);
            } else {
                Thread.sleep(Math.round(Math.random()*(this.let-this.eet)+this.eet)*timeUnitControl);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Supervisor--------------\n";

        if(!placeHandler.GetPlaceByName("ps_i2").IsNull()){
            toPrint = toPrint.concat(Print() + "\n");

            placeHandler.GetPlaceByName("ps_2").Set(placeHandler.GetPlaceByName("ps_i2").Get());
            placeHandler.GetPlaceByName("ps_o2").Set(placeHandler.GetPlaceByName("ps_i2").Get());
            placeHandler.GetPlaceByName("ps_i2").Set(null);

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
