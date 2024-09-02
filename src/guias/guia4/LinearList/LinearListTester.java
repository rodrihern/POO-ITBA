package guias.guia4.LinearList;

public class LinearListTester {
    public static void main(String[] args) {
        LinearList list = new Listorti();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list.size()); //6
        System.out.println(list.get(4)); // 5
        list.set(4, 20);
        System.out.println(list.get(4)); // 20
        System.out.println(list.indexOf(2)); // 1
        list.remove(1);
        System.out.println(list.indexOf(2)); // -1
        System.out.println(list.size()); // 5
    }
}
