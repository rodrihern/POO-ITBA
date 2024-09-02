package guias.guia3.Figure;

public class Ellipse extends Figure{
    protected Point centerPoint;
    double a;
    double b;

    public Ellipse(Point centerPoint, double bigAxis, double smallAxis) {
        this.centerPoint = centerPoint;
        this.a = bigAxis / 2;
        this.b = smallAxis / 2;
    }

    @Override
    public double area() {
        return Math.PI * a * b;
    }

    @Override
    public double perimeter() {
        return Math.PI * (2*a + 2*b) / 2;
    }

    @Override
    public String toString() {
        return "Elipse [ Centro: %s , DMayor: %.2f , DMenor: %.2f ]".formatted(centerPoint.toString(), a*2, b*2);
    }

    protected Point getCenterPoint() {
        return centerPoint;
    }

    protected double getA() {
        return a;
    }




}
