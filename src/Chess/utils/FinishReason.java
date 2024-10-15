package Chess.utils;

public enum FinishReason {
    WHITE_MATE("White wins by checkmate"),
    BLACK_MATE("Black wins by checkmate"),
    STALEMATE("The game ends in a draw by stalemate"),
    REPETITION("The game ends in a draw by repetition"),
    FIFTY_MOVE_RULE("The game ends in a draw by fifty move rule");

    private final String msg;

    FinishReason(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
