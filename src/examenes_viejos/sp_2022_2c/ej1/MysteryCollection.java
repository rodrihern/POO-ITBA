package examenes_viejos.sp_2022_2c.ej1;

import java.util.List;
import java.util.SortedSet;

public interface MysteryCollection<T extends Comparable<? super T>> extends SortedSet<T> {
    <E extends Comparable<? super E>> List<Pair<T, E>> zip(MysteryCollection<E> other);
}
