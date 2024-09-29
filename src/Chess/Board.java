package Chess;

import Chess.utils.Color;
import Chess.utils.PieceType;
import Chess.utils.Square;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Board {

    private static final int DIM = 8;
    private Piece[][] board, prevBoard;
    private Square whiteKing, blackKing;

    public Board() {
        board = new Piece[DIM][DIM];
        whiteKing = new Square("e1");
        blackKing = new Square("e8");
        // kings
        board[whiteKing.getRow()][whiteKing.getCol()] = new Piece(Color.WHITE, PieceType.KING);
        board[blackKing.getRow()][blackKing.getCol()] = new Piece(Color.BLACK, PieceType.KING);
        // queens
        board[0][3] = new Piece(Color.BLACK, PieceType.QUEEN);
        board[7][3] = new Piece(Color.WHITE, PieceType.QUEEN);
        // rooks
        board[0][0] = board[0][7] = new Piece(Color.BLACK, PieceType.ROOK);
        board[7][0] = board[7][7] = new Piece(Color.WHITE, PieceType.ROOK);
        // knights
        board[0][1] = board[0][6] = new Piece(Color.BLACK, PieceType.KNIGHT);
        board[7][1] = board[7][6] = new Piece(Color.WHITE, PieceType.KNIGHT);
        // bishops
        board[0][2] = board[0][5] = new Piece(Color.BLACK, PieceType.BISHOP);
        board[7][2] = board[7][5] = new Piece(Color.WHITE, PieceType.BISHOP);
        // pawns
        for(int j = 0; j < DIM; j++) {
            board[1][j] = new Piece(Color.BLACK, PieceType.PAWN);
        }
        for(int j = 0; j < DIM; j++) {
            board[6][j] = new Piece(Color.WHITE, PieceType.PAWN);
        }

    }


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
