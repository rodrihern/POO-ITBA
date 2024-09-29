package Chess;

import Chess.utils.Color;
import Chess.utils.PieceType;
import Chess.utils.Square;

public class Move {
    private final Piece piece;
    private final Square dest;

    public Move(Piece piece, Square dest) {
        this.piece = piece;
        this.dest = dest;
    }

    public Move(String move, Color color) {
        if(move.length() != 6) {
            throw new IllegalArgumentException("invalid move");
        }
        PieceType type = null;
        for(PieceType pt : PieceType.values()) {
            if(move.substring(0, 1) == pt.toString()) {
                type = pt;
                break;
            }
        }
        // Nb1-c3
        // 012345
        Square from = new Square(move.substring(1, 3));
        this.dest = new Square(move.substring(4));
        this.piece = new Piece(type, color, from);
    }

    public Piece getPiece() {
        return piece;
    }

    public Square getDest() {
        return dest;
    }

    public Square getFrom() {
        return piece.getSquare();
    }
}
