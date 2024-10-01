package Chess.utils;

import Chess.Board;
import Chess.Piece;

public enum PieceType {
    KING("K", Direction.values()) {
        @Override
        public boolean canMove(Color color, Square from, Square to, Piece[][] board) {
            int i = to.getRow();
            int j = to.getCol();
            int rowInc = i - from.getRow();
            int colInc = j - from.getCol();
            if(Math.abs(rowInc) > 1 || Math.abs(colInc) > 1 || (rowInc == 0 && colInc == 0)) {
                return false;
            }
            return board[i][j] == null || !board[i][j].getColor().equals(color);
        }
    },
    QUEEN("Q", Direction.values()),
    BISHOP("B", Direction.diagonal()),
    ROOK("R", Direction.straight()),
    KNIGHT("N", null) {
        @Override
        public boolean canMove(Color color, Square from, Square to, Piece[][] board) {
            int i = to.getRow();
            int j = to.getCol();
            int rowInc = i - from.getRow();
            int colInc = j - from.getCol();
            if((Math.abs(rowInc) == 2 && Math.abs(colInc) == 1) || (Math.abs(rowInc) == 1 && Math.abs(colInc) == 2)) {
                return board[i][j] == null || !board[i][j].getColor().equals(color);
            }
            return false;
        }
    },
    PAWN("P", new Direction[]{Direction.UP, Direction.UPLEFT, Direction.UPRIGHT}) {
        @Override
        public boolean canMove(Color color, Square from, Square to, Piece[][] board) {
            // moving straight
            boolean isWhite = color.equals(Color.WHITE);
            boolean canMove2steps = isWhite && from.getRow() == 6 || !isWhite && from.getRow() == 1;
            Direction dir = isWhite ? Direction.UP : Direction.DOWN;
            int i = from.getRow() + dir.getRowInc();
            int j = from.getCol();
            boolean hitObstacle = board[i][j] != null;
            if(i == to.getRow() && j == to.getCol()) {
                return !hitObstacle;
            }
            i += dir.getRowInc();
            if(canMove2steps && i == to.getRow() && j == to.getCol() && !hitObstacle) {
                return board[i][j] == null;
            }
            // moving diagonally
            Direction[] directions;
            if(isWhite) {
                directions = new Direction[]{Direction.UPLEFT, Direction.UPRIGHT};
            } else {
                directions = new Direction[]{Direction.DOWNLEFT, Direction.DOWNRIGHT};
            }
            for(Direction d : directions) {
                i = from.getRow() + d.getRowInc();
                j = from.getCol() + d.getColInc();
                if(i == to.getRow() && j == to.getCol()) {
                    return !color.equals(board[i][j].getColor());
                }
            }
            return false;
        }
    };

    private final String value;
    private final Direction[] directions;

    PieceType(String value, Direction[] directions) {
        this.value = value;
        this.directions = directions;
    }

    public Direction[] getDirections() {
        return directions;
    }

    public boolean canMove(Color color, Square from, Square to, Piece[][] board) {
        for(Direction dir : directions) {
            boolean sthInTheWay = false;
            int i = from.getRow() + dir.getRowInc();
            int j = from.getCol() + dir.getColInc();
            while (0 <= i && i < board.length && 0<= j && j < board[0].length && !sthInTheWay) {
                if(to.equals(new Square(i, j))) {
                    return board[i][j] == null || !board[i][j].getColor().equals(color);
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

    @Override
    public String toString() {
        return value;
    }
}
