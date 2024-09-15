package examenes_viejos.pp_Repaso.Pizza;

public abstract class Pizza {
    private double price;
    Topping[] toppings;

    public Pizza(double defaultPrize, Topping[] toppings) {
        this.toppings = toppings;
        price = defaultPrize;
        for(Topping t : toppings) {
            price += t.getPrice();
        }
    }


    protected String toPizzaString(String s) {
        StringBuilder str = new StringBuilder("Pizza ");
        str.append(s).append(" ");
        // aca va el for
        for(Topping t : toppings) {
            str.append(t.toString()).append(" ");
        }
        str.append(": $%.2f".formatted(price));

        return str.toString();
    }
}
