package guias.guia5.Pair;

import java.util.Objects;

public class Pair<A extends Comparable<? super A>, B extends Comparable<? super B>> implements Comparable<Pair<A, B>>{
    private A a;
    private B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Pair<?,?> pair) && a.equals(pair.a) && b.equals(pair.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "[ %s , %s ]".formatted(a, b);
    }

    public void setA(A a) {
        this.a = a;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public int compareTo(Pair<A, B> o) {
        int cmp = a.compareTo(o.a);
        if(cmp == 0) {
            cmp = b.compareTo(o.b);
        }
        return cmp;
    }
}
