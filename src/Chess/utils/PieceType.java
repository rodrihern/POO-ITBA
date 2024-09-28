package Chess.utils;

public enum PieceType {
    KING("K", Direction.values()) {
        @Override
        public Direction canMove(Color color, Square from, Square to) {
            int rowInc = to.getRow() - from.getRow();
            int colInc = to.getCol() - from.getCol();
            for(Direction dir : getDirections()) {
                if(rowInc == dir.getRowInc() && colInc == dir.getColInc()) {
                    return dir;
                }
            }
            return null;
        }
    },
    QUEEN("Q", Direction.values()),
    BISHOP("B", new Direction[]{Direction.UPLEFT, Direction.UPRIGHT, Direction.DOWNLEFT,  Direction.DOWNRIGHT}),
    ROOK("R", new Direction[]{Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT}),
    KNIGHT("N", null) {
        @Override
        public Direction canMove(Color color, Square from, Square to) {
            int rowInc = to.getRow() - from.getRow();
            int colInc = to.getCol() - from.getCol();
            if((Math.abs(rowInc) == 2 && Math.abs(colInc) == 1) || (Math.abs(rowInc) == 1 && Math.abs(colInc) == 2)) {
                return Direction.UP; // return no null, it could be any direction
            }
            return null;
        }
    },
    PAWN("P", new Direction[]{Direction.UP, Direction.UPLEFT, Direction.UPRIGHT}) {
        @Override
        public Direction canMove(Color color, Square from, Square to) {
            int rowInc = to.getRow() - from.getRow();
            int colInc = to.getCol() - from.getCol();
            if(color.equals(Color.WHITE)) {
                if(rowInc == -2 && to.getRow() == 6) {
                    return colInc == 0 ? Direction.UP : null;
                }
                for(Direction dir : getDirections()) {
                    if(rowInc == dir.getRowInc() && colInc == dir.getColInc()) {
                        return dir;
                    }
                }
            } else {
                if(rowInc == 2 && to.getRow() == 1) {
                    return colInc == 0 ? Direction.DOWN : null;
                }
                for(Direction dir : new Direction[]{Direction.DOWN, Direction.DOWNLEFT, Direction.DOWNRIGHT}) {
                    if(rowInc == dir.getRowInc() && colInc == dir.getColInc()) {
                        return dir;
                    }
                }
            }
            return null;
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

    // returns the direction in which it moved or null if it is unable to move to that square
    public Direction canMove(Color color, Square from, Square to) {
        for(Direction dir : directions) {
            int i = from.getRow() + dir.getRowInc();
            int j = from.getCol() + dir.getColInc();
            while (0 <= i && i <= 7 && 0<= j && j <= 7) {
                if(to.equals(new Square(i, j))) {
                    return dir;
                }
                i += dir.getRowInc();
                j += dir.getColInc();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
