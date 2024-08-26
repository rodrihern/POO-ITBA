package guias.guia3;

public class Ej3 {
    public static void main(String[] args) {
        Point p1 = new Point(2, 1);
        Point p2 = new Point(2, 1);
        System.out.println("3.1: " + (p1 == p2));
        System.out.println("3.2: " + p1.equals(p2));
        System.out.println("3.4: " + (p1 instanceof Object));
        System.out.println("3.7: " + p1);
    }
}
