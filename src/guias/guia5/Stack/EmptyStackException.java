package guias.guia5.Stack;

public class EmptyStackException extends RuntimeException{
    public static final String MESSAGE = "cannot pop an empty stack";

    EmptyStackException() {
        super(MESSAGE);
    }

    EmptyStackException(String msg) {
        super(msg);
    }
}
