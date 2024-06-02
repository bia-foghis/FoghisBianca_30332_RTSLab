package Part1.Interfaces;

public interface ITransition {
    public void Init(String name, IPlaceHandler placeHandler);

    public void SetDelay(int value);

    public void SetDelayInRange(int eet, int let);

    public void TransitionDelay();

    public Boolean TransitionGuardsMappings();

    public String Print();
}
