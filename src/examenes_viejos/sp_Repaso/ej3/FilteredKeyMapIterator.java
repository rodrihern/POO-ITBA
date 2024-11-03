package examenes_viejos.sp_Repaso.ej3;

import java.util.*;
import java.util.function.Predicate;

public class FilteredKeyMapIterator<K, V> implements Iterator<K> {

    private final Map<K, V> map;
    private final Iterator<K> it;
    private K currentKey;

    public FilteredKeyMapIterator(Map<K, V> map, Predicate<K> keyPredicate) {
        this.map = map;
        Set<K> filteredKeySet = new HashSet<>();
        for(K key : map.keySet()) {
            if(keyPredicate.test(key)) {
                filteredKeySet.add(key);
            }
        }
        it = filteredKeySet.iterator();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public K next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return currentKey = it.next();
    }

    public V getValue() {
        if(currentKey == null) {
            throw new NoSuchElementException();
        }
        return map.get(currentKey);
    }

}

