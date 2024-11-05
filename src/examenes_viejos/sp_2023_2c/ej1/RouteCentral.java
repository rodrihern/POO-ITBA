package examenes_viejos.sp_2023_2c.ej1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

public class RouteCentral {
    Map<String, Map<String, Integer>> routes = new HashMap<>();
    UnaryOperator<Integer> costConverter;

    public RouteCentral(UnaryOperator<Integer> costConverter) {
        this.costConverter = costConverter;
    }

    public void addOneWayRoute(String from, String to, int cost) {
        routes.putIfAbsent(from, new HashMap<>());
        routes.get(from).putIfAbsent(to, cost);
    }

    public void addTwoWayRoute(String from, String to, int totalCost) {
        int cost = costConverter.apply(totalCost);
        addOneWayRoute(from, to, cost);
        addOneWayRoute(to, from, cost);
    }

    public void changeRouteCost(String from, String to, int newCost) {
        checkRoute(from, to);
        routes.get(from).put(to, newCost);
    }

    public int getDirectRouteMiles(String from, String to) {
        checkRoute(from, to);
        return routes.get(from).get(to);
    }

    public int getOneStopRouteMiles(String from, String stop, String to) {
        return getDirectRouteMiles(from, stop) + getDirectRouteMiles(stop, to);
    }

    private void checkRoute(String from, String to) {
        if(!routes.containsKey(from) || !routes.get(from).containsKey(to)) {
            throw new IllegalArgumentException("Route does not exist.");
        }
    }
}
