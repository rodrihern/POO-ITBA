package guias.guia4.Expression;

public class OrExpression extends BinaryExpression{
    public OrExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public boolean evaluate() {
        return right.evaluate() || left.evaluate();
    }
}
