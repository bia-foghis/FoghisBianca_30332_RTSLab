package Part1.Interfaces;

public interface IPlace {
    String GetPlaceName();
    void SetPlaceName(String name);
    Object Get();
    Boolean IsNull();
    void Set(Object value);
    String Print();
    void Init(String name, Object value);
}
