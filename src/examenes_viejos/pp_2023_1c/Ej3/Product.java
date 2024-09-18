package examenes_viejos.pp_2023_1c.Ej3;

public abstract class Product {
    private final String name;
    private final Brand brand;
    private final double price;

    public Product(String name, Brand brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getFinalPrice() {
        return brand.applyDiscount(price);
    }

    public double getFinalPrice(Warranty w) {
        return this.getFinalPrice() + w.getIncrement(price);
    }

    @Override
    public String toString() {
        return "%s from %s with price $%.2f".formatted(name, brand, price);
    }
}
