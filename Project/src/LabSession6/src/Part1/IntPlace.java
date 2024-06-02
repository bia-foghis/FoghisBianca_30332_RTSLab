package Part1;

import LabSession6.Part1.Interfaces.IPlace;

public class IntPlace implements IPlace {
    protected String name;
    protected Integer value;

    public IntPlace(String name, Object value){
        this.Init(name, value);
    }

    @Override
    public String GetPlaceName() {
        return this.name;
    }

    @Override
    public void SetPlaceName(String name) {
        this.name = name;
    }

    @Override
    public Object Get() {
        return this.value;
    }

    @Override
    public Boolean IsNull() {
        return this.Get() == null;
    }

    @Override
    public void Set(Object value) {
        this.value = (Integer) value;
    }

    @Override
    public String Print() {
        return "[" + this.name + "=" + this.value + "]";
    }

    @Override
    public void Init(String name, Object value) {
        this.SetPlaceName(name);
        this.Set(value);
    }
}
