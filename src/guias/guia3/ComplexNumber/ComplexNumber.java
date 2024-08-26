package guias.guia3.ComplexNumber;

import java.util.Objects;

public class ComplexNumber {
    private double realPart;
    private double imagPart;

    public ComplexNumber(double real, double imaginary) {
        realPart = real;;
        imagPart = imaginary;
    }

    public ComplexNumber(double real) {
        realPart = real;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ComplexNumber num)) {
            return false;
        }
        return this.realPart == num.realPart && this.imagPart == num.imagPart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realPart, imagPart);
    }

    public ComplexNumber plus(double real) {
        return new ComplexNumber(this.realPart + real, this.imagPart);
    }

    public ComplexNumber plus(ComplexNumber num) {
        return new ComplexNumber(this.realPart + num.realPart, this.imagPart + num.imagPart);
    }

    @Override
    public String toString() {
        return "%.2f %s %.2f i".formatted(realPart, imagPart < 0 ? "-" : "+" ,imagPart);
    }

}

