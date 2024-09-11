package guias.guia5.CyclicWindowIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicWindowIterator<T> implements Iterator<T[]> {
    private final T[] array;
    private final int n;
    private int idx;

    public CyclicWindowIterator(T[] array, int n) {
        this.array = array;
        this.n = n;
        idx = 0;
    }

    @Override
    public boolean hasNext() {
        return array.length > 0;
    }

    @Override
    public T[] next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        T[] ans = (T[]) new Object[n];
        int j = idx++;
        idx %= array.length;
        for(int i = 0; i < n; i++) {
            ans[i] = array[j++];
            j %= array.length;
        }

        return ans;
    }
}
