package examenes_viejos.pp_2023_2c.Ej2;

public class CannotEnterLoungeException extends RuntimeException{
    public static final String MESSAGE = "Cannot enter Launge";

    public CannotEnterLoungeException() {
        super(MESSAGE);
    }
}
