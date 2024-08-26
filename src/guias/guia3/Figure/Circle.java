package guias.guia3.Figure;

public class Circle extends Ellipse {
    public Circle(Point cp, double radius) {
        super(cp, 2*radius, 2*radius);
    }

    @Override
    public String toString() {
        return "Circulo [ Centro: %s , Radio: %.2f ]".formatted(super.getCenterPoint().toString(), getA());
    }
}
