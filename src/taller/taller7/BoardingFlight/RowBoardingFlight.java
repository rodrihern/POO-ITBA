package taller.taller7.BoardingFlight;

import java.util.Comparator;

public class RowBoardingFlight extends BoardingFlight {
    public RowBoardingFlight() {
        super((p1, p2) -> {
            int cmp = p1.getRow() - p2.getRow();
            if(cmp == 0) {
                cmp = p1.toString().compareTo(p2.toString());
            }
            return cmp;
        });

    }
}
