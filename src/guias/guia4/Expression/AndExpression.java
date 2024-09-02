package guias.guia4.Expression;

public class AndExpression extends BinaryExpression{
    public AndExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public boolean evaluate() {
        return right.evaluate() && left.evaluate();
    }
}
