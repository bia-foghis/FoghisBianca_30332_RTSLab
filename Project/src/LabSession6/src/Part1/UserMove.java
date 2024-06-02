package Part1;

public class UserMove {
    Integer r;
    Integer e;
    Integer l;

    public UserMove(Integer r, Integer e, Integer l){
        this.r = r;
        this.e = e;
        this.l = l;
    }

    @Override
    public String toString() {
        return "UserMove{" +
                "r=" + r +
                ", e=" + e +
                ", l=" + l +
                '}';
    }
}
