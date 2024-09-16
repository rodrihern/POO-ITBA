package examenes_viejos.pp_2023_2c.Ej2;

public class EmptyLaungeException extends RuntimeException{
    public static final String MESSAGE = "Lounge is empty";

    public EmptyLaungeException() {
        super(MESSAGE);
    }
}
