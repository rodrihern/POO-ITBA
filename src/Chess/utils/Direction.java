package Chess.utils;

public enum Direction {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),
    UPLEFT(-1, -1),
    UPRIGHT(-1, 1),
    DOWNLEFT(1, -1),
    DOWNRIGHT(1, 1);

    private final int rowInc, colInc;

    Direction(int rowInc, int colInc) {
        this.rowInc = rowInc;
        this.colInc = colInc;
    }

    public static Direction[] diagonal() {
        return new Direction[]{Direction.UPLEFT, Direction.UPRIGHT, Direction.DOWNLEFT,  Direction.DOWNRIGHT};
    }

    public static Direction[] straight() {
        return  new Direction[]{Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT};
    }

    public int getRowInc() {
        return rowInc;
    }

    public int getColInc() {
        return colInc;
    }
}
