package Part1;

import LabSession6.Part1.Interfaces.IPlace;

import java.util.List;

public class ListUserPlace implements IPlace {
    String name;
    List<UserMove> value;

    public ListUserPlace(String name, List<UserMove> listOfUserMoves){
        this.Init(name, listOfUserMoves);
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
        this.value.add((UserMove)value);
    }

    @Override
    public String Print() {
        String print = "[" + this.name + "=";
        for (UserMove userMove : value){
            if(userMove != null){
                print = print.concat(userMove.toString());
            }
        }

        print = print.concat("]");

        return print;
    }

    @Override
    public void Init(String name, Object value) {
        this.name = name;
        this.value = (List<UserMove>) value;
    }
}
