package examenes_viejos.pp_2023_1c.Ej3;

public class InvalidDiscountException extends RuntimeException {
    public static final String MESSAGE = "Invalid Discount for brand %s";

    public InvalidDiscountException(String brand) {
        super(MESSAGE.formatted(brand));
    }
}
