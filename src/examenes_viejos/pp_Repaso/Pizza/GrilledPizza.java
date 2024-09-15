package examenes_viejos.pp_Repaso.Pizza;

public class GrilledPizza extends Pizza{
    private static final double PRICE = 150;

    public GrilledPizza(Topping[] toppings) {
        super(PRICE, toppings);
    }

    @Override
    public String toString() {
        return super.toPizzaString("a la parrilla");
    }
}
