package Chess;

import Chess.utils.Color;
import Chess.utils.Direction;
import Chess.utils.PieceType;
import Chess.utils.Square;

import java.util.Arrays;

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

    private boolean canMakeMove(Piece piece, Square from, Square to) {
        // terminar
        return false;
    }

    private boolean isUnderAttack(Square sq) {
        Piece p = board[sq.getRow()][sq.getCol()];
        if(p == null) {
            return false;
        }
        for(Direction dir : Direction.values()) {
            Square otherSq = pieceSqInDir(sq, dir);
            if(otherSq != null) {
                Piece otherPiece = board[otherSq.getRow()][otherSq.getCol()];
                if(!otherPiece.getColor().equals(p.getColor()) && otherPiece.canMove(otherSq, sq) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Square pieceSqInDir(Square sq, Direction dir) {
        int i = sq.getRow() + dir.getRowInc();
        int j = sq.getCol() + dir.getColInc();
        while(0 <= i && i < DIM && 0 <= j && j < DIM) {
            if(board[i][j] != null) {
                return new Square(i, j);
            }
        }
        return null;
    }

    private Piece[][] boardCopy() {
        Piece[][] ans = new Piece[DIM][DIM];
        for(int i = 0; i < DIM; i++) {
            ans[i] = Arrays.copyOf(board[i], DIM);
        }
        return ans;
    }


}
