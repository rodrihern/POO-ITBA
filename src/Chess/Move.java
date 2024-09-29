package Chess;

import Chess.utils.Color;
import Chess.utils.PieceType;
import Chess.utils.Square;

public class Move {
    private final Piece piece;
    private final Square from, to;

    public Move(Piece piece, Square from, Square to) {
        this.piece = piece;
        this.from = from;
        this.to = to;
    }

    public Move(String move, Color color) {
        if(move.length() != 6) {
            throw new IllegalArgumentException("invalid move");
        }
        PieceType type = null;
        for(PieceType pt : PieceType.values()) {
            if(move.substring(0, 1).equals(pt.toString())) {
                type = pt;
                break;
            }
        }
        // Nb1-c3
        // 012345
        from = new Square(move.substring(1, 3));
        to = new Square(move.substring(4));
        this.piece = new Piece(color, type);
    }

    public Piece getPiece() {
        return piece;
    }

    public Square getFrom() {
        return from;
    }

    public Square getTo() {
        return to;
    }
}
