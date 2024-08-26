package guias.guia3.Figure;

public class Triangle extends Figure{
    private Point p1, p2, p3;
    double a, b, c;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        a = p1.distanceTo(p2);
        b = p2.distanceTo(p3);
        c = p3.distanceTo(p1);

    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        double semip = perimeter() / 2.0;
        return Math.sqrt(semip * (semip - a) * (semip - b) * (semip - c));
    }

    @Override
    public String toString() {
        return "Triangulo [ %s , %s , %s]".formatted(p1.toString(), p2.toString(), p3.toString());
    }
}
