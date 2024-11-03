package examenes_viejos.sp_Repaso.ej1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SimpleArrayList<T> extends ArrayList<T> implements SimpleList<T> {

    @Override
    public <K> Map<K, T> toMap(Function<T, K> fun) {
        Map<K, T> ans = new HashMap<>();
        for(T e : this) {
            ans.put(fun.apply(e), e);
        }
        return ans;
    }
}
