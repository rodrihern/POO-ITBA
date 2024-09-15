package examenes_viejos.pp_Repaso.Pizza;

public class OvenPizza extends Pizza {
    private static final double PRICE = 100;

    public OvenPizza(Topping[] toppings) {
        super(PRICE, toppings);
    }

    @Override
    public String toString() {
        return super.toPizzaString("al horno");
    }
}
