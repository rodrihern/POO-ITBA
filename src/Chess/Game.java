package Chess;

import Chess.Pieces.Piece;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        int count = 0;
        for(Piece p : board) {
            if(p == null) {
                System.out.print(". ");
            } else {
                System.out.print(p + " ");
            }
            if(++count % 8 == 0) {
                System.out.print("\n");
            }
        }
    }
}
