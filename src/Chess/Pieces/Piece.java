package Chess.Pieces;

import Chess.Color;

import java.util.ArrayList;

public abstract class Piece {
    Color color;
    int row, col;

    public Piece(Color color, int row, int col) {
        if(row < 0 || row > 7 || col < 0 || col > 7) {
            throw new IllegalArgumentException();
        }
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return !isWhite();
    }

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void moveTo(int row, int col) {
        this.row = row;
        this.col = col;
    }

    protected boolean canMoveTo(int row, int col, ArrayList<int[]> directions) {
        for(int[] dir: directions) {
            int i = this.row;
            int j = this.col;

            while(0 <= i && i <= 7 && 0<= j && j <= 7) {
                if(i == row && j == col) {
                    return true;
                }
                i += dir[0];
                j += dir[1];
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "*";
    }
}
