package Chess;

import Chess.utils.Color;
import Chess.utils.Direction;
import Chess.utils.PieceType;
import Chess.utils.Square;

import java.util.Objects;

public class Piece {
    private final PieceType type;
    private final Color color;
    Square sq;

    public Piece(PieceType type, Color color, Square sq) {
        this.type = type;
        this.color = color;
        this.sq = sq;
    }

    public PieceType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Square getSquare() {
        return sq;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Piece p &&
                this.type == p.type &&
                this.color == p.color &&
                this.sq == p.sq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, sq);
    }

    @Override
    public String toString() {
        return color == Color.WHITE ? type.toString() : type.toString().toLowerCase();
    }

    public Direction canMoveTo(Square dest) {
        return type.canMove(color, sq, dest);
    }

    public void moveTo(Square sq) {
        this.sq = sq;
    }
}
