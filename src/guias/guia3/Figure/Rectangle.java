package guias.guia3.Figure;

public class Rectangle extends Figure {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point tl, Point br) {
        this.topLeft = tl;
        this.bottomRight = br;
    }

    public double base() {
        return  Math.abs(bottomRight.getX() - topLeft.getX());
    }

    public double height() {
        return Math.abs(topLeft.getY() - bottomRight.getY());
    }

    @Override
    public double area() {
        return base() * height();
    }

    @Override
    public double perimeter() {
        return 2 * base() + 2 * height();
    }

    @Override
    public String toString() {
        return "Rectangulo [ %s , %s ]".formatted(topLeft.toString(), bottomRight.toString());
    }
}
