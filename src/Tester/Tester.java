package Tester;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        myClass c = new myClass();
        System.out.println(c.getOtherClassState());
        c.getSt().setState(false);
        System.out.println(c.getOtherClassState());
    }

}

