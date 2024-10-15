package Chess;

import Chess.utils.*;

import java.util.*;

public class Board {

    private static final int DIM = 8;
    private Piece[][] board;
    private Square whiteKing, blackKing;
    private boolean cwcs, cwcl, cbcs, cbcl, god;
    FinishReason finishReason;
    private List<Piece[][]> prevPositions = new ArrayList<>();
    private List<Move> allMoves = new ArrayList<>();
    private Collection<Move> legalMoves = new HashSet<>();

    public Board() {
        board = new Piece[DIM][DIM];
        whiteKing = new Square("e1");
        blackKing = new Square("e8");
        cwcs = cwcl = cbcs = cbcl = true;
        god = false;
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

        calculateLegalMoves(Color.WHITE);

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

    public Piece getPiece(Square sq) {
        return board[sq.getRow()][sq.getCol()];
    }

    public int size() {
        return DIM;
    }

    Collection<Move> getAllMoves() {
        return new ArrayList<>(allMoves);
    }

    Collection<Move> getLegalMoves() {
        return new HashSet<>(legalMoves);
    }

    public FinishReason getFinishReason() {
        return finishReason;
    }

    public boolean toggleGod() {
        return god = !god;
    }

    public boolean hasLegalMoves() {
        return !legalMoves.isEmpty();
    }

    // TODO
    public void makeMove(Move newMove) {
        if(!legalMoves.contains(newMove)) {
            throw new IllegalArgumentException("Illegal Move");
        }
        // acordarse de manejar los flags de castling
        // acordarse de actualizar el coso de legalMoves una vez hacho el movimiento
        // manejar enpassant y enroque

    }

    public boolean isInCheck(Color color) {
        return color.equals(Color.WHITE) ? isUnderAttack(whiteKing) : isUnderAttack(blackKing);
    }

    public boolean canCastle(CastleType ct) {
        if((ct == CastleType.WHITE_SHORT && !cwcs) || (ct == CastleType.WHITE_LONG && !cwcl)
                || (ct == CastleType.BLACK_SHORT && !cbcs) || (ct == CastleType.BLACK_LONG && !cbcl)
        ) {
            return false;
        }
        for(Square sq : ct.path()) {
            if(board[sq.getRow()][sq.getCol()] != null || isUnderAttack(sq)) {
                return false;
            }
        }
        return true;
    }

    // es como un putPiece full obediente
    public void promote(Square sq, Piece promotingTo) {
        board[sq.getRow()][sq.getCol()] = promotingTo;
    }

    // TODO
    private void calculateLegalMoves(Color color) {
        // solo los normales (enpassant y castle los hago aparte en makemove)
    }

    // TODO
    private boolean isLegal(Square from, Square to) {
        return true;
    }

    private boolean isUnderAttack(Square sq) {
        Piece p = board[sq.getRow()][sq.getCol()];
        for(Direction dir : Direction.values()) {
            Square otherSq = pieceSqInDir(sq, dir);
            if(otherSq != null) {
                Piece otherPiece = board[otherSq.getRow()][otherSq.getCol()];
                if(otherPiece.isAttacking(otherSq, sq, this) && (p == null || !otherPiece.getColor().equals(p.getColor()))) {
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
            i += dir.getRowInc();
            j += dir.getColInc();
        }
        return null;
    }

    private Piece[][] getBoardCopy() {
        Piece[][] ans = new Piece[DIM][DIM];
        for(int i = 0; i < DIM; i++) {
            ans[i] = Arrays.copyOf(board[i], DIM);
        }
        return ans;
    }




}
