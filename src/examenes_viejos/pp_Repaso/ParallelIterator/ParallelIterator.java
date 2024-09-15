package examenes_viejos.pp_Repaso.ParallelIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParallelIterator<T> implements Iterator<ParallelIterator.Pair<T>> {

    private final T[] v1, v2;
    private int idx;

    public ParallelIterator(T[] v1, T[] v2) {
        if(v1 == null) {
            throw new RuntimeException("First Collection missing");
        }
        if(v2 == null) {
            throw new RuntimeException("Second Collection missing");
        }
        this.v1 = v1;
        this.v2 = v2;
        idx = 0;
    }

    @Override
    public boolean hasNext() {
        return idx < v1.length && idx < v2.length;
    }

    @Override
    public Pair<T> next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return new Pair<T>(v1[idx], v2[idx++]);
    }

    public static class Pair<E> {
        private final E left, right;

        public Pair(E left, E right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "{ %s , %s }".formatted(left.toString(), right.toString());
        }
    }
}
