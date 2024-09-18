package examenes_viejos.pp_2023_1c.Ej3;

public enum Efficiency {
    A(0),
    B(0.1),
    C(0.2);

    private final double taxPercentage;

    Efficiency(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double getTax(double price) {
        return price * taxPercentage;
    }

}
