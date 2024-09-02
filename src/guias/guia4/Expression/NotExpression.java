package guias.guia4.Expression;

public class NotExpression extends Expression{
    private Expression exp;

    public NotExpression(Expression exp) {
        this.exp = exp;
    }


    @Override
    public boolean evaluate() {
        return !exp.evaluate();
    }
}
