package examenes_viejos.pp_Repaso.Pizza;

public class PizzaTester {

    public static void main(String[] args) {
        // Pizza a la parrilla con Tomate
        Pizza pizza1 = new GrilledPizza(new Topping[]{Topping.TOMATO});
        // Pizza a la parrilla con Tomate con Cebolla con Extra queso
        Pizza pizza2 = new GrilledPizza(new Topping[] {Topping.TOMATO, Topping.ONION ,Topping.CHEESE});
        // Pizza al horno con Cebolla con Extra queso
        Pizza pizza3 = new OvenPizza(new Topping[] {Topping.ONION, Topping.CHEESE});
        System.out.println(pizza1);
        System.out.println(pizza2);
        System.out.println(pizza3);
    }

}

