package examenes_viejos.pp_2023_1c.Ej3;

public class Device extends Product{

    private final Efficiency label;

    public Device(String name, Brand brand, double price, Efficiency label) {
        super(name, brand, price);
        this.label = label;
    }

    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() + label.getTax(super.getPrice());
    }

    @Override
    public String toString() {
        return "[Device] %s with Energy label %s".formatted(super.toString(), label);
    }


}
