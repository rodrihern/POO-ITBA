package examenes_viejos.pp_2024_1c.Ej3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class AirPort {
    private Counter[] counters;
    private static final int DEFAULT_SIZE = 10;
    private int idx;

    public AirPort() {
        counters = new Counter[DEFAULT_SIZE];
        idx = 0;
    }

    private void resize() {
        counters = Arrays.copyOf(counters, counters.length + DEFAULT_SIZE);
    }

    public Counter addCounter(String airline) {
        Counter newCounter = new Counter(airline, idx);
        if(idx == counters.length) {
            resize();
        }
        counters[idx++] = newCounter;

        return newCounter;
    }

    void counterCheckIn(Predicate<Counter> predicate) {
        for(int i = 0; i < idx; i++) {
            if(predicate.test(counters[i])) {
                counters[i].checkIn();
                return;
            }
        }
    }

    public Counter[] airlineOrderCounters() {
        Counter[] ans = Arrays.copyOf(counters, idx);
        Arrays.sort(ans);
        return ans;
    }

    public Counter[] airlineDescendingOrderCounters() {
        Counter[] ans = Arrays.copyOf(counters, idx);
        Arrays.sort(ans, Comparator.reverseOrder());
        return ans;
    }
}
