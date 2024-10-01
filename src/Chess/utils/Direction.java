package Chess.utils;

public enum Direction {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),
    UPLEFT(-1, -1),
    UPRIGHT(-1, 1),
    DOWNLEFT(1, -1),
    DOWNRIGHT(1, 1),
    KNIGHT_UL(-2, -1),
    KNIGHT_UR(-2, 1),
    KNIGHT_DL(2, -1),
    KNIGHT_DR(2, 1),
    KNIGHT_LU(-1, -2),
    KNIGHT_LD(1, -2),
    KNIGHT_RU(-1, 2),
    KNIGHT_RD(1, 2)
    ;

    private final int rowInc, colInc;

    Direction(int rowInc, int colInc) {
        this.rowInc = rowInc;
        this.colInc = colInc;
    }

    public static Direction[] diagonal() {
        return new Direction[]{UPLEFT, UPRIGHT, DOWNLEFT,  DOWNRIGHT};
    }

    public static Direction[] straight() {
        return  new Direction[]{UP, DOWN, LEFT, RIGHT};
    }

    public static Direction[] normalDirections() {
        return new Direction[]{
                UP, DOWN, LEFT, RIGHT, UPLEFT, UPRIGHT, DOWNLEFT,  DOWNRIGHT
        };
    }

    public static Direction[] knightDirections() {
        return new Direction[]{
                KNIGHT_UL, KNIGHT_UR, KNIGHT_DL, KNIGHT_DR, KNIGHT_LU, KNIGHT_LD, KNIGHT_RU, KNIGHT_RD
        };
    }

    public int getRowInc() {
        return rowInc;
    }

    public int getColInc() {
        return colInc;
    }
}
