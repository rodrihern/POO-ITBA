package examenes_viejos.pp_2024_1q.Ej2;

public class InvalidPaymentPlanException extends RuntimeException {
    public static final String MESSAGE = "Invalid payment plan";

    public InvalidPaymentPlanException() {
        super(MESSAGE);
    }
}
