package guias.guia4.Expression;

public abstract class Expression {

    public abstract boolean evaluate();

    public Expression not() {
        return new NotExpression(this);
    }

    public Expression or(Expression expression) {
        return new OrExpression(this, expression);
    }

    public Expression and(Expression expression) {
        return new AndExpression(this, expression);
    }

}

