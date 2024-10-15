package Chess.utils;

import java.util.ArrayList;
import java.util.Collection;

public enum CastleType {
    WHITE_SHORT(new Square("e1"), new Square("h1"), 1),
    WHITE_LONG(new Square("e1"), new Square("a1"), -1),
    BLACK_SHORT(new Square("e8"), new Square("h8"), 1),
    BLACK_LONG(new Square("e8"), new Square("a8"), -1);

    private final Square king, rook;
    private final int dj;
    CastleType(Square king, Square rook, int dj) {
        this.king = king;
        this.rook = rook;
        this.dj = dj;
    }

    public Square getKing() {
        return king;
    }

    public Square getRook() {
        return rook;
    }

    public Collection<Square> path() {
        Collection<Square> ans = new ArrayList<>();
        Square aux = new Square(king.getRow(), king.getCol() + dj);
        while (aux != rook) {
            ans.add(new Square(aux.getRow(), aux.getCol()));
            aux = new Square(aux.getRow(), aux.getCol() + dj);
        }
        return ans;

    }


}
