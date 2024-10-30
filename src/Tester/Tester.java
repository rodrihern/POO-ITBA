package Tester;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List<myClass> myArr = new ArrayList<>();
        myArr.add(new myClass());
        myArr.add(new myClass());
        myArr.add(new myClass());
        myArr.add(new myClass());
        myArr.add(new myClass());
        System.out.println(myArr);
        for(myClass c : myArr) {
            c.setNum(4);
        }
        System.out.println(myArr);
    }
}
