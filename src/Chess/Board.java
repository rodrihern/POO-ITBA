package Chess;

import Chess.Pieces.Piece;
import Chess.Pieces.Rook;
import Chess.utils.Color;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Board implements Iterable<Piece> {

    private Piece[][] board = new Piece[8][8];

    public Board() {
        board[0][0] = new Rook(Color.BLACK, 0, 0);
        board[0][7] = new Rook(Color.BLACK, 0, 7);
        board[7][0] = new Rook(Color.WHITE, 7, 0);
        board[7][7] = new Rook(Color.WHITE, 7, 7);
    }

    @Override
    public Iterator<Piece> iterator() {
        return new Iterator<>() {
            int i = 0, j = 0;
            @Override
            public boolean hasNext() {
                return i <= 7;
            }

            @Override
            public Piece next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                Piece ans = board[i][j];
                if(j == 7) {
                    i++;
                    j = 0;
                } else {
                    j++;
                }
                return ans;
            }
        };
    }
}
