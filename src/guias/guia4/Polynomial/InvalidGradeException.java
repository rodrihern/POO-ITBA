package guias.guia4.Polynomial;

public class InvalidGradeException extends Exception{
    public static final String MESSAGE = "Grado invalido";

    public InvalidGradeException() {
        super(MESSAGE);
    }
}
