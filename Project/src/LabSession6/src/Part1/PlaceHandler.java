package Part1;

import LabSession6.Part1.Interfaces.IPlace;
import LabSession6.Part1.Interfaces.IPlaceHandler;

import java.util.ArrayList;

public class PlaceHandler implements IPlaceHandler {

    ArrayList<IPlace> listOfPlaces;

    public PlaceHandler(){
        listOfPlaces = new ArrayList<IPlace>();
    }

    @Override
    public void AddPlace(IPlace place) {
        listOfPlaces.add(place);
    }

    @Override
    public IPlace GetPlaceByName(String name) {
        for (IPlace place : listOfPlaces){
            if(place.GetPlaceName() == name){
                return place;
            }
        }
        return null;
    }

    @Override
    public String PrintAllPlaces() {
        String toPrint = "";
        for (IPlace place : listOfPlaces){
            toPrint = toPrint.concat(place.Print());
        }

        return toPrint;
    }
}
