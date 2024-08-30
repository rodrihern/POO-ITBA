package taller.taller4;

public interface List<T> {

    void add(T elem);

    boolean remove(int position);

    int contains(T elem);

    boolean isEmpty();

    default boolean removeElement(T elem) {
       return remove(contains(elem));
    }
}
