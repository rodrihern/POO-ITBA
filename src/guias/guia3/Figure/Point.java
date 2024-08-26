package guias.guia3.Figure;

import java.util.Objects;

public class Point {

    private final double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Point otherPoint) {
        double xSquared = Math.pow(this.x - otherPoint.x, 2);
        double ySquared = Math.pow(this.y - otherPoint.y, 2);
        return Math.sqrt(xSquared + ySquared);
    }


    @Override
    public boolean equals(Object obj) {
        return obj instanceof Point p && this.x == p.x && this.y == p.y;
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{%g, %g}".formatted(x, y);
    }

}

