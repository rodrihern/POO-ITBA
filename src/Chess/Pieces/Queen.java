package Chess.Pieces;

import Chess.Color;

public class Queen extends Piece{
    Bishop myBish;
    Rook myRook;

    public Queen(Color color, int row, int col) {
        super(color, row, col);
        myBish = new Bishop(color, row, col);
        myRook = new Rook(color, row, col);
    }

    @Override
    public void moveTo(int row, int col) {
        if(myBish.canMoveTo(row, col) || myRook.canMoveTo(row, col)) {
            super.moveTo(row, col);
            myBish = new Bishop(super.getColor(), row, col);
            myRook = new Rook(super.getColor(), row, col);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return isWhite() ? "Q" : "q";
    }
}
