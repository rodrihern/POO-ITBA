package guias.guia4.Movable;

public class MovableTester {
    public static void main(String[] args) {
        MovablePoint aPoint = new MovablePoint(1,2);
        MovableEllipse anEllipse = new MovableEllipse(aPoint,2,3);
        System.out.println(anEllipse);
        anEllipse.moveNorth(3);
        System.out.println(anEllipse);
    }
}
