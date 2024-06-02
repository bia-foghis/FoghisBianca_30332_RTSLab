package Part1.Interfaces;

public interface IPlaceHandler {
    void AddPlace(IPlace place);
    IPlace GetPlaceByName(String name);
    String PrintAllPlaces();
}
