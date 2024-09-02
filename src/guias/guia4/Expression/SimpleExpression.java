package guias.guia4.Expression;

public class SimpleExpression extends Expression {
    boolean value;

    public SimpleExpression(boolean value) {
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate() {
        return value;
    }
}
