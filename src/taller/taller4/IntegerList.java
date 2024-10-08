package taller.taller4;

import java.util.Arrays;

public class IntegerList implements List<Integer> {


    private Integer[] array;
    private int dim;
    private static final int DEFAULT_SIZE = 10;

    public IntegerList() {
        array = new Integer[DEFAULT_SIZE];
        dim = 0;
    }

    @Override
    public void add(Integer elem) {
        if(dim == array.length) {
            resize();
        }
        array[dim++] = elem;
    }

    @Override
    public boolean remove(int idx) {
        if(idx < 0 || idx >= dim) {
            return false;
        }
        array[idx] = array[--dim];
        return true;
    }

    @Override
    public int contains(Integer elem) {
        for(int i = 0; i < dim; i++) {
            if(array[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return dim == 0;
    }

    private void resize() {
        array = Arrays.copyOf(array, array.length + DEFAULT_SIZE);
    }
}
