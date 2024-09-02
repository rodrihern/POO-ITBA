package guias.guia4.Movable;


import guias.guia3.Figure.Point;

public class MovablePoint extends Point implements Movable {
    public MovablePoint(double x, double y) {
        super(x, y);
    }

    @Override
    public void moveNorth(double delta) {
        setY(getY() + delta);
    }

    @Override
    public void moveSouth(double delta) {
        setY(getY() - delta);
    }

    @Override
    public void moveWest(double delta) {
        setX(getX() - delta);
    }

    @Override
    public void moveEast(double delta) {
        setX(getX() + delta);
    }
}
