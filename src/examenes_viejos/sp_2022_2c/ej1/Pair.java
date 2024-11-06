package examenes_viejos.sp_2022_2c.ej1;

public class Pair<A, B> {
    private final A left;
    private final B right;

    public Pair(A left, B right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("{ %s <> %s }", left, right);
    }
}

