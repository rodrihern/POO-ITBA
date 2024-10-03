package taller.taller8;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class SimpleArrayList<T> extends ArrayList<T> implements SimpleList<T> {
    @Override
    public <R> SimpleList<R> map(Function<T, R> fun)  {
        SimpleList<R> ans = new SimpleArrayList<>();
        for(T elem : this) {
            ans.add(fun.apply(elem));
        }
        return ans;
    }


}
