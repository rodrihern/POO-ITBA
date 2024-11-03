package examenes_viejos.sp_2024_1c.ej1;

import java.util.*;
import java.util.function.Predicate;

public class MatchCollectionImpl<T extends Comparable<? super T>> extends ArrayList<T> implements MatchCollection<T> {
    private final List<Predicate<T>> predicates = new ArrayList<>();

    @Override
    public void addMatchPredicate(Predicate<T> predicate) {
        predicates.add(predicate);
    }

    @Override
    public SequencedSet<T> getAllMatched() {
        SequencedSet<T> ans = new TreeSet<>();
        for(T elem : this) {
            boolean isValid = true;
            for(Predicate<T> p : predicates) {
                if(!p.test(elem)) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                ans.add(elem);
            }
        }
        return ans;
    }
}
