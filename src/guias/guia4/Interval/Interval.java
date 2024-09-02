package guias.guia4.Interval;

import java.util.Objects;

public class Interval {
    private double start, end, step;

    public Interval(double start, double end, double step) {
        this.start = start;
        this.end = end;
        this.step = step;
        if(size() == 0) {
            throw new IllegalArgumentException("Empty interval");
        }

    }

    public Interval(double start, double end) {
        this(start, end, 1);
    }

    public long size() {
        return Math.max(0, (int) ((end - start) / step) + 1);
    }

    public double at(long idx) {
        if(idx > size()) {
            throw new IllegalArgumentException("Out of bounds");
        }
        return start + idx * step;
    }

    public long indexOf(double value) {
        double first, last, increment;
        if(start <= end) {
            first = start;
            last = end;
            increment = step;
        } else {
            first = end;
            last = start;
            increment = -step;
        }
        double num = first;
        for(long i = 0; num <= last; i++, num += increment) {
            if(Double.compare(value, num) == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean includes(double value) {
        return indexOf(value) != -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[ %.2f".formatted(start));
        for(double num = start + step; (start < end && num <= end) || (end < start && num >= end); num += step) {
            str.append(" , %.2f".formatted(num));
        }
        str.append(" ]");
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Interval i &&
                (Double.compare(i.start, start) == 0) &&
                (Double.compare(i.end, end) == 0) &&
                (Double.compare(i.step, step) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, step);
    }

    public long count(IntervalCondition condition) {
        int ans = 0;
        double first, last, increment;
        if(start < end) {
            first = start;
            last = end;
            increment = step;
        } else {
            first = end;
            last = start;
            increment = -step;
        }
        for(double num = first; num <= last; num += increment) {
            if(condition.satisfies(num)) {
                ans++;
            }
        }
        return ans;
    }
}
