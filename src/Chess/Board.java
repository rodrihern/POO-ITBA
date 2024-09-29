package Chess;

import Chess.utils.Color;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Board {

    private static final int DIM = 8;
    private Piece[][] board = new Piece[DIM][DIM];

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < DIM; i++) {
            for(int j = 0; j < DIM; j++) {
                String toAppend = board[i][j] == null ? "." : board[i][j].toString();
                str.append(toAppend).append("  ");
            }
            str.append("\n");
        }

        return str.toString();
    }


}
