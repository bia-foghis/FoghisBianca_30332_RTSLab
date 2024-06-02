package Part1;

import LabSession6.Part1.Interfaces.IPlaceHandler;
import LabSession6.Part1.Interfaces.ITransition;

public class Transition_t_1_Controller implements ITransition {
    Integer timeUnitControl = 500;
    Integer eet;
    Integer let;
    String name;
    IPlaceHandler placeHandler;

    public Transition_t_1_Controller(String name, IPlaceHandler placeHandler, Integer delay){
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
            if(this.let == null){
                Thread.sleep(this.eet * timeUnitControl);
            } else {
                Thread.sleep(Math.round(Math.random()*(this.let - this.eet) + this.eet)*timeUnitControl);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        this.TransitionDelay();
        String toPrint="--------------Controller--------------\n";
        if(!placeHandler.GetPlaceByName("p_i1").IsNull() && !placeHandler.GetPlaceByName("p_1").IsNull()){
            if(placeHandler.GetPlaceByName("p_i1").Get() == placeHandler.GetPlaceByName("p_1").Get()){
                toPrint = toPrint.concat(this.Print() + "\n");

                placeHandler.GetPlaceByName("p_2").Set(0);
                placeHandler.GetPlaceByName("p_i1").Set(null);
                placeHandler.GetPlaceByName("p_1").Set(null);

                toPrint = toPrint.concat(this.Print() + "\n");
                toPrint = toPrint.concat("--------------------------------------\n");

                System.out.println(toPrint);

                return true;
            }

            if ((Integer)placeHandler.GetPlaceByName("p_i1").Get() > (Integer)placeHandler.GetPlaceByName("p_1").Get()){
                toPrint = toPrint.concat(this.Print() + "\n");

                placeHandler.GetPlaceByName("p_2").Set(1);
                placeHandler.GetPlaceByName("p_1").Set(null);

                toPrint = toPrint.concat(this.Print() + "\n");
                toPrint = toPrint.concat("--------------------------------------\n");

                System.out.println(toPrint);

                return true;
            }

            if((Integer)placeHandler.GetPlaceByName("p_i1").Get() < (Integer)placeHandler.GetPlaceByName("p_1").Get()){
                toPrint = toPrint.concat(this.Print() + "\n");

                placeHandler.GetPlaceByName("p_2").Set(-1);
                placeHandler.GetPlaceByName("p_1").Set(null);

                toPrint = toPrint.concat(this.Print() + "\n");
                toPrint = toPrint.concat("--------------------------------------\n");

                System.out.println(toPrint);

                return true;
            }
        }

        return false;
    }

    @Override
    public String Print() {
        return this.name + "\n" + this.placeHandler.PrintAllPlaces();
    }
}
