package examenes_viejos.pp_2023_1c.Ej1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

public class CustomIndex<T> implements Iterable<T> {

    private UnaryOperator<Integer> unaryOperator;
    private final int from, to;
    private final T[] array;

    public CustomIndex(T[] array, int from, int to, UnaryOperator<Integer> uop) {
        if(to <= from) {
            throw new IllegalArgumentException("Invalid combination of start and end index");
        }
        this.array = array;
        this.from = from;
        this.to = to;
        this.unaryOperator = uop;
    }

    public void setNextIndex(UnaryOperator<Integer> uop) {
        this.unaryOperator = uop;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int idx = from;
            private final UnaryOperator<Integer> uop = unaryOperator;

            @Override
            public boolean hasNext() {
                return idx <= to && idx < array.length;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                T ans = array[idx];
                idx = uop.apply(idx);
                return ans;
            }
        };
    }
}
