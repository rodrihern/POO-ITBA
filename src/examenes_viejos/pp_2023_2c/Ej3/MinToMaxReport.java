package examenes_viejos.pp_2023_2c.Ej3;

import java.util.Arrays;
import java.util.Comparator;

public class MinToMaxReport<T>  implements ReportCollection<T> {
    private final Comparator<? super T> cmp;
    private T[] array;
    private int dim;
    public static final int DEFAULT_SIZE = 10;

    @SuppressWarnings("unchecked")
    public MinToMaxReport(Comparator <? super T> cmp) {
        this.cmp = cmp;
        dim = 0;
        array = (T[]) new Object[DEFAULT_SIZE];
    }

    private void resize() {
        array = Arrays.copyOf(array, array.length + DEFAULT_SIZE);
    }

    @Override
    public void add(T report) {
        if(array.length >= dim) {
            resize();
        }
        array[dim++] = report;
    }

    @Override
    public T get(int idx) {
        if(idx < 0 || idx >= dim) {
            throw new IllegalArgumentException();
        }
        return array[idx];
    }

    @Override
    public T[] reports() {
        T[] ans = Arrays.copyOf(array, dim);
        Arrays.sort(ans, cmp);
        return ans;
    }



}
