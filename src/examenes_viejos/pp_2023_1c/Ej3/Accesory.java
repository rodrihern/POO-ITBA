package examenes_viejos.pp_2023_1c.Ej3;

public class Accesory extends Product {
    String feature;

    public Accesory(String name, Brand brand, double price, String feature) {
        super(name, brand, price);
        this.feature = feature;
    }

    @Override
    public String toString() {
        return "[Accesory] %s with feature %s".formatted(super.toString(), feature);
    }
}
