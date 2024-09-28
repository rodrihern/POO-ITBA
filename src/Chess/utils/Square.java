package Chess.utils;

import java.util.Objects;

public class Square {
   private final int row, col;

    public Square(int row, int col) {
        if(row < 0 || row > 7 || col < 0 || col > 7) {
            throw new IllegalArgumentException("invalid square");
        }
        this.row = row;
        this.col = col;
    }

    public Square(String sq) {
        this('8' - sq.charAt(1), sq.charAt(0) - 'a');
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Square sq && this.row == sq.row && this.col == sq.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
