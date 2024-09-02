package guias.guia4.CellPhoneBill;

public class TooManyFriendsException extends NumberException{
    private static final String MESSAGE = "too many friends";

    public TooManyFriendsException(String number) {
        super(number, MESSAGE);
    }
}
