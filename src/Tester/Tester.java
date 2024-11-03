package Tester;


import java.util.SortedSet;
import java.util.TreeSet;

public class Tester {
    public static void main(String[] args) {
        SortedSet<myClass> mySet = new TreeSet<>((o1, o2) -> o1.getNum() - o2.getNum());
        mySet.add(new myClass(1));
        mySet.add(new myClass(10));
        mySet.add(new myClass(2));
        mySet.add(new myClass(5));
        mySet.add(new myClass(3));
        mySet.add(new myClass(20));
        mySet.add(new myClass(17));
        System.out.println(mySet);


    }
}
