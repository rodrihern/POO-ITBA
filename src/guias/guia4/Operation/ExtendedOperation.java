package guias.guia4.Operation;

public enum ExtendedOperation implements Operation {
    POWER("^", (x, y) -> Math.pow(x, y)),
    REMAINDER("%", (x, y) -> x % y);

    ExtendedOperation(String symbol, Operation op) {
        this.symbol = symbol;
        this.op = op;
    }

    private final String symbol;
    private final Operation op;


    @Override
    public double apply(double n1, double n2) {
        return op.apply(n1, n2);
    }

    @Override
    public String toString() {
        return "%s".formatted(symbol);
    }
}
