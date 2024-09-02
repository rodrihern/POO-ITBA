package guias.guia4.Polynomial;

public class InvalidIndexException extends Exception {
    public static final String MESSAGE = "Indice invalido";

    public InvalidIndexException() {
        super(MESSAGE);
    }
}
