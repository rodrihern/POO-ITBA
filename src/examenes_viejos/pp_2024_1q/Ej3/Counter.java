package examenes_viejos.pp_2024_1q.Ej3;

public class Counter implements Comparable<Counter> {

    private boolean isIdle;
    private final int idx;
    private final String airline;

    Counter(String airline, int idx) {
        this.airline = airline;
        this.idx = idx;
        isIdle = true;
    }

    public void checkIn() {
        isIdle = false;
    }

    public boolean getIsIdle() {
        return isIdle;
    }

    public String getAirline() {
        return airline;
    }

    @Override
    public int compareTo(Counter o) {
        int cmp = airline.compareTo(o.airline);
        if(cmp == 0) {
            cmp = idx - o.idx;
        }

        return cmp;
    }

    @Override
    public String toString() {
        String state = isIdle ? "idle" : "checking in";
        return "Counter %d for %s is %s".formatted(idx, airline, state);
    }
}
