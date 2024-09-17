package examenes_viejos.pp_2023_2c.Ej3;

import java.util.Comparator;

public class MaxToMinReport<T> extends MinToMaxReport<T> {
    public MaxToMinReport(Comparator<? super T> cmp) {
        super(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return cmp.compare(o2, o1);
            }
        });
    }
}
