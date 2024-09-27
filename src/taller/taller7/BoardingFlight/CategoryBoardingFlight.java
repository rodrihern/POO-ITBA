package taller.taller7.BoardingFlight;

import java.util.Comparator;

public class CategoryBoardingFlight extends BoardingFlight {
    public CategoryBoardingFlight() {
        // yo lo habia hecho con un lambda pero me tira esta el ide
        super(Comparator.comparing(Passenger::getCategory).thenComparing(Passenger::toString));
    }

}
