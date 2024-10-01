package Chess;

import Chess.utils.Color;
import Chess.utils.PieceType;
import Chess.utils.Square;

import java.util.Collection;
import java.util.Objects;

public class Piece {
    private final PieceType type;
    private final Color color;

    public Piece(Color color, PieceType type) {
        this.type = type;
        this.color = color;
    }

    public PieceType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Piece p && this.type.equals(p.type)&& this.color.equals(p.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }

    @Override
    public String toString() {
        return color == Color.WHITE ? type.toString() : type.toString().toLowerCase();
    }

    public boolean canMove(Square from, Square to, Board board) {
        return type.canMove(color, from, to, board.getBoardCopy());
    }

    public Collection<Square> getPossibleDest(Square from, Board board) {
        return type.getPossibleDest(from, board.getBoardCopy(), color);
    }

}
