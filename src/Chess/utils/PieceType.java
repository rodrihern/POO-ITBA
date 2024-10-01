package Chess.utils;

import Chess.Piece;

import java.util.ArrayList;
import java.util.Collection;

public enum PieceType {
    KING("K", Direction.normalDirections()) {
        @Override
        public boolean canMove(Color color, Square from, Square to, Piece[][] board) {
            int i = to.getRow();
            int j = to.getCol();
            int rowInc = i - from.getRow();
            int colInc = j - from.getCol();
            if(Math.abs(rowInc) > 1 || Math.abs(colInc) > 1 || (rowInc == 0 && colInc == 0)) {
                return false;
            }
            return canOccupySq(i, j, color, board);
        }

        @Override
        public Collection<Square> getPossibleDest(Square from, Piece[][] board, Color color) {
            return possibleDestOneSq(from, board, color, Direction.normalDirections());
        }
    },
    QUEEN("Q", Direction.normalDirections()),
    BISHOP("B", Direction.diagonal()),
    ROOK("R", Direction.straight()),
    KNIGHT("N", Direction.knightDirections()) {
        @Override
        public boolean canMove(Color color, Square from, Square to, Piece[][] board) {
            int i = to.getRow();
            int j = to.getCol();
            int rowInc = i - from.getRow();
            int colInc = j - from.getCol();
            if((Math.abs(rowInc) == 2 && Math.abs(colInc) == 1) || (Math.abs(rowInc) == 1 && Math.abs(colInc) == 2)) {
                return canOccupySq(i, j, color, board);
            }
            return false;
        }

        @Override
        public Collection<Square> getPossibleDest(Square from, Piece[][] board, Color color) {
            return possibleDestOneSq(from, board, color, Direction.knightDirections());
        }
    },
    PAWN("P", new Direction[]{Direction.UP, Direction.UPLEFT, Direction.UPRIGHT}) {
        @Override
        public boolean canMove(Color color, Square from, Square to, Piece[][] board) {
            boolean isWhite = color.equals(Color.WHITE);
            boolean canMove2steps = isWhite && from.getRow() == 6 || !isWhite && from.getRow() == 1;
            Direction[] directions;
            if(isWhite) {
                directions = new Direction[]{Direction.UP, Direction.UPLEFT, Direction.UPRIGHT};
            } else {
                directions = new Direction[]{Direction.DOWN, Direction.DOWNLEFT, Direction.DOWNRIGHT};
            }
            for(Direction dir : directions) {
                int i = from.getRow() + dir.getRowInc();
                int j = from.getCol() + dir.getColInc();
                if(dir.equals(Direction.UP) || dir.equals(Direction.DOWN)) {
                    if(to.equals(new Square(i, j))) {
                        return board[i][j] == null;
                    }
                    i += dir.getRowInc();
                    j += dir.getColInc();
                    if(canMove2steps && to.equals(new Square(i, j))) {
                        return board[i][j] == null;
                    }
                } else {
                    if(to.equals(new Square(i, j))) {
                        return isTaking(i, j, color, board);
                    }
                }
            }
            return false;
        }

        @Override
        public Collection<Square> getPossibleDest(Square from, Piece[][] board, Color color) {
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
                if(dir.equals(Direction.UP) || dir.equals(Direction.DOWN)) {
                    if(board[i][j] == null) {
                        ans.add(new Square(i, j));
                    }
                    i += dir.getRowInc();
                    j += dir.getColInc();
                    if(canMove2steps && board[i][j] == null) {
                        ans.add(new Square(i, j));
                    }
                } else {
                    if(isTaking(i, j, color, board)) {
                        ans.add(new Square(i, j));
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

    protected Direction[] getDirections() {
        return directions;
    }

    public boolean canMove(Color color, Square from, Square to, Piece[][] board) {
        for(Direction dir : directions) {
            boolean sthInTheWay = false;
            int i = from.getRow() + dir.getRowInc();
            int j = from.getCol() + dir.getColInc();
            while (isWithinLimits(i, j, board) && !sthInTheWay) {
                if(to.equals(new Square(i, j))) {
                    return canOccupySq(i, j, color, board);
                }
                if(board[i][j] != null) {
                    sthInTheWay = true;
                }
                i += dir.getRowInc();
                j += dir.getColInc();
            }
        }
        return false;
    }

    public Collection<Square> getPossibleDest(Square from, Piece[][] board, Color color) {
        Collection<Square> ans = new ArrayList<>();
        for(Direction dir : directions) {
            boolean hitSomething = false;
            int i = from.getRow() + dir.getRowInc();
            int j = from.getCol() + dir.getColInc();
            while (isWithinLimits(i, j, board) && !hitSomething) {
                if(canOccupySq(i, j, color, board)) {
                    ans.add(new Square(i, j));
                } else {
                    hitSomething = true;
                }
                i += dir.getRowInc();
                j += dir.getColInc();
            }
        }
        return ans;
    }

    private static boolean isWithinLimits(int i, int j, Piece[][] board) {
        return 0 <= i && i < board.length && 0<= j && j < board[0].length;
    }

    private static boolean canOccupySq(int i, int j, Color color, Piece[][] board) {
        return board[i][j] == null || isTaking(i, j, color, board);
    }

    private static boolean isTaking(int i, int j, Color color, Piece[][] board) {
        return !color.equals(board[i][j].getColor());
    }

    private static Collection<Square> possibleDestOneSq(Square from, Piece[][] board, Color color, Direction[] directions) {
        Collection<Square> ans = new ArrayList<>();
        for(Direction dir : directions) {
            int i = from.getRow() + dir.getRowInc();
            int j = from.getCol() + dir.getColInc();
            if(PieceType.isWithinLimits(i, j, board) && canOccupySq(i, j, color, board)) {
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
