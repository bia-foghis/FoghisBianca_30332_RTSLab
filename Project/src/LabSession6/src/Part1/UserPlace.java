package Part1;

import LabSession6.Part1.Interfaces.IPlace;

public class UserPlace implements IPlace {
    String name;
    UserMove value;

    public UserPlace(String name, UserMove value){
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
        this.value = (UserMove)value;
    }

    @Override
    public String Print() {
        if(this.value == null){
            return "[" + this.name + "=" + null + "]";
        }

        return "[" + this.name + "=" + this.value.toString() + "]";
    }

    @Override
    public void Init(String name, Object value) {
        this.name = name;
        this.value = (UserMove) value;
    }
}
