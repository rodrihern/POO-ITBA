package examenes_viejos.pp_Repaso.Pizza;

public abstract class Pizza {
    private final double defaultPrice;
    Topping[] toppings;

    public Pizza(double defaultPrize, Topping[] toppings) {
        this.toppings = toppings;
        this.defaultPrice = defaultPrize;
    }


    protected String toPizzaString(String s) {
        StringBuilder str = new StringBuilder("Pizza ");
        double price = defaultPrice;
        str.append(s).append(" ");
        for(Topping t : toppings) {
            price += t.getPrice();
            str.append(t.toString()).append(" ");
        }
        str.append(": $%.2f".formatted(price));

        return str.toString();
    }
}
