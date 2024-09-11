package guias.guia5.ReversedIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReversedIterator<T> implements Iterator<T> {

    private final T[] array;
    private int idx;

    public ReversedIterator(T[] array) {
        this.array = array;
        idx = array.length - 1;
    }

    @Override
    public boolean hasNext() {
        return idx >= 0;
    }

    @Override
    public T next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[idx--];
    }
}
