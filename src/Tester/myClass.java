package Tester;

public class myClass {

    private final State st = new State();

    public State getSt() {
        return st;
    }

    public boolean getOtherClassState() {
        return st.getState();
    }
}
