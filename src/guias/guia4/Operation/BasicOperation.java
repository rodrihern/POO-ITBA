package guias.guia4.Operation;

public enum BasicOperation implements Operation {
    SUM("+", (x, y) -> x + y),
    SUBSTRACT("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y) ,
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private Operation op;

    BasicOperation(String operator, Operation op) {
        this.symbol = operator;
        this.op = op;
    }

    @Override
    public String toString() {
        return "%s".formatted(symbol);
    }


    @Override
    public double apply(double n1, double n2) {
        return op.apply(n1, n2);
    }
}
