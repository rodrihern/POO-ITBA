package Tester;

public class myClass {

    private final State st;

    public myClass(State st) {
        this.st = st;
    }

    public boolean getOtherClassState() {
        return st.getState();
    }
}
