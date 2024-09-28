package Chess.Pieces;

import Chess.Color;

import java.util.ArrayList;

public class Rook extends Piece {
    ArrayList<int[]> directions = new ArrayList<>();

    public Rook(Color color, int row, int col) {
        super(color, row, col);
        directions.add(new int[]{0, 1});
        directions.add(new int[]{0, -1});
        directions.add(new int[]{1, 0});
        directions.add(new int[]{-1, 0});
    }

    public boolean canMoveTo(int row, int col) {
        return super.canMoveTo(row, col, directions);
    }

    @Override
    public void moveTo(int row, int col) {
        if(!canMoveTo(row, col)) {
            throw new IllegalArgumentException();
        }
        super.moveTo(row, col);
    }
}
