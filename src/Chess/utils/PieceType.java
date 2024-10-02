package Chess.utils;

import Chess.Board;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public enum PieceType {
    KING("K", Direction.normalDirections()) {
        @Override
        public Collection<Square> getPossibleDest(Square from, Board board, Color color) {
            return possibleDestOneSq(from, board, color, Direction.normalDirections());
        }
    },
    QUEEN("Q", Direction.normalDirections()),
    BISHOP("B", Direction.diagonal()),
    ROOK("R", Direction.straight()),
    KNIGHT("N", Direction.knightDirections()) {
        @Override
        public Collection<Square> getPossibleDest(Square from, Board board, Color color) {
            return possibleDestOneSq(from, board, color, Direction.knightDirections());
        }
    },
    PAWN("P", new Direction[]{Direction.UP, Direction.UPLEFT, Direction.UPRIGHT}) {
        @Override
        public Collection<Square> getPossibleDest(Square from, Board board, Color color) {
            boolean isWhite = color.equals(Color.WHITE);
            boolean canMove2steps = isWhite && from.getRow() == 6 || !isWhite && from.getRow() == 1;
            Collection<Square> ans = new ArrayList<>();
            Direction[] directions;
            if(isWhite) {
                directions = new Direction[]{Direction.UP, Direction.UPLEFT, Direction.UPRIGHT};
            } else {
                directions = new Direction[]{Direction.DOWN, Direction.DOWNLEFT, Direction.DOWNRIGHT};
            }
            for(Direction dir : directions) {
                int i = from.getRow() + dir.getRowInc();
                int j = from.getCol() + dir.getColInc();
                Square sq = new Square(i, j);
                if(dir.equals(Direction.UP) || dir.equals(Direction.DOWN)) {
                    if(board.getPiece(sq) == null) {
                        ans.add(sq);
                    }
                    i += dir.getRowInc();
                    j += dir.getColInc();
                    sq = new Square(i, j);
                    if(canMove2steps && board.getPiece(sq) == null) {
                        ans.add(sq);
                    }
                } else {
                    if(isTaking(sq, color, board)) {
                        ans.add(sq);
                    }
                }
            }
            return ans;
        }
    };

    private final String value;
    private final Direction[] directions;

    PieceType(String value, Direction[] directions) {
        this.value = value;
        this.directions = directions;
    }

    public Collection<Square> getPossibleDest(Square from, Board board, Color color) {
        Collection<Square> ans = new HashSet<>();
        for(Direction dir : directions) {
            boolean hitSomething = false;
            int i = from.getRow() + dir.getRowInc();
            int j = from.getCol() + dir.getColInc();
            while (isWithinLimits(i, j, board) && !hitSomething) {
                Square sq = new Square(i, j);
                if(canOccupySq(sq, color, board)) {
                    ans.add(sq);
                } else {
                    hitSomething = true;
                }
                i += dir.getRowInc();
                j += dir.getColInc();
            }
        }
        return ans;
    }

    private static boolean isWithinLimits(int i, int j, Board board) {
        return 0 <= i && i < board.size() && 0<= j && j < board.size();
    }

    private static boolean canOccupySq(Square sq, Color color, Board board) {
        return board.getPiece(sq) == null || isTaking(sq, color, board);
    }

    private static boolean isTaking(Square sq, Color color, Board board) {
        return !color.equals(board.getPiece(sq).getColor());
    }

    private static Collection<Square> possibleDestOneSq(Square from, Board board, Color color, Direction[] directions) {
        Collection<Square> ans = new ArrayList<>();
        for(Direction dir : directions) {
            int i = from.getRow() + dir.getRowInc();
            int j = from.getCol() + dir.getColInc();
            if(PieceType.isWithinLimits(i, j, board) && canOccupySq(new Square(i, j), color, board)) {
                ans.add(new Square(i, j));
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        return value;
    }
}
