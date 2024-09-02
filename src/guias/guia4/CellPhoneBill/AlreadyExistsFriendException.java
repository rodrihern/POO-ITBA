package guias.guia4.CellPhoneBill;

public class AlreadyExistsFriendException extends NumberException {
    private static final String MESSAGE = "Friend already exists";

    public AlreadyExistsFriendException(String number) {
        super(number, MESSAGE);
    }

}
