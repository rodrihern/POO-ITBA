package examenes_viejos.sp_2024_1c.ej1;

import java.util.List;
import java.util.SequencedCollection;
import java.util.function.Predicate;

public interface MatchCollection<T extends Comparable<? super T>> extends List<T> {
    void addMatchPredicate(Predicate<T> predicate);

    SequencedCollection<T> getAllMatched();

    default SequencedCollection<T> getAllMatchedReversed() {
        return getAllMatched().reversed();
    }
}
