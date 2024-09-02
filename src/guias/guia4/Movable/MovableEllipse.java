package guias.guia4.Movable;

import guias.guia3.Figure.Ellipse;


public class MovableEllipse extends Ellipse implements Movable {


    public MovableEllipse(MovablePoint centerPoint, double sMayorAxis, double sMinorAxis) {
        super(centerPoint, sMayorAxis, sMinorAxis);
    }

    @Override
    public void moveNorth(double delta) {
        ((MovablePoint)centerPoint).moveNorth(delta);
    }

    @Override
    public void moveSouth(double delta) {
        ((MovablePoint)centerPoint).moveSouth(delta);
    }

    @Override
    public void moveWest(double delta) {
        ((MovablePoint)centerPoint).moveWest(delta);
    }

    @Override
    public void moveEast(double delta) {
        ((MovablePoint)centerPoint).moveEast(delta);
    }

}



