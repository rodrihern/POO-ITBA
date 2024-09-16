package Tester;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        State st = new State();
        myClass c = new myClass(st);
        System.out.println(c.getOtherClassState());
        st.setState(false);
        System.out.println(c.getOtherClassState());
    }

}

