package examenes_viejos.pp_Repaso.Pizza;

public enum Topping {
    TOMATO(30, "Tomate"),
    CHEESE(20, "Extra queso"),
    ONION(10, "Cebolla");

    private final double price;
    private final String description;

    Topping(double price, String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "con " + description;
    }

    public double getPrice() {
        return price;
    }
}
