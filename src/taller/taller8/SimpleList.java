package taller.taller8;


import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface SimpleList<T> extends List<T> {
    <R> SimpleList<R>  map(Function<T, R> fun);
}
