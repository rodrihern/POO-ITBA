package examenes_viejos.sp_2022_2c.ej1;

import java.util.*;

public class MysteryCollectionImpl<T extends Comparable<? super T>> extends TreeSet<T> implements MysteryCollection<T>  {

    public MysteryCollectionImpl() {
        super(Comparator.reverseOrder());
    }

    @Override
    public <E extends Comparable<? super E>> List<Pair<T, E>> zip(MysteryCollection<E> other) {
        List<Pair<T, E>> ans = new ArrayList<>();
        Iterator<T> thisIt = this.iterator();
        Iterator<E> otherIt = other.iterator();
        while(thisIt.hasNext() && otherIt.hasNext()) {
            ans.add(new Pair<>(thisIt.next(), otherIt.next()));
        }
        return ans;
    }
}
