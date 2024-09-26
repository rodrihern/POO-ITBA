package taller.taller7.BoardingFlight;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class BoardingFlight {
    SortedSet<Passenger> passengers;

    public BoardingFlight(Comparator<Passenger> cmp) {
        passengers = new TreeSet<>(cmp);
    }

    public boolean addForBoarding(String name, int row, PassengerCategory category) {
        return passengers.add(new Passenger(name, row, category));
    }

    public Iterator<Passenger> boardingCallIterator() {
        return passengers.iterator();
    }
}
