package examenes_viejos.sp_Repaso.ej4;

import java.util.*;

public abstract class BoardingFlight {
    private final SortedSet<Passenger> passengers;

    public BoardingFlight(Comparator<Passenger> cmp) {
        passengers = new TreeSet<>(cmp);
    }

    public void addForBoarding(String name, int row, PassengerCategory category) {
        passengers.add(new Passenger(name, row, category));
    }

    public Iterator<String> boardingCallIterator() {
        return new Iterator<String>() {
            Iterator<Passenger> it = passengers.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public String next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return it.next().toString();
            }
        };
    }
}
