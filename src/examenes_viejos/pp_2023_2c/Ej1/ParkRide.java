package examenes_viejos.pp_2023_2c.Ej1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParkRide implements Iterable<ParkSlot> {
    private final String name;
    private final LocalTime open;
    private LocalTime close;
    private final long duration;

    public ParkRide(String name, LocalTime open, LocalTime close, long duration) {
        if(close.isBefore(open)) {
            throw new IllegalArgumentException("Close time cannot be before open time");
        }
        if(duration <= 0) {
            throw new IllegalArgumentException("Slot minutes must be positive");
        }
        this.name = name;
        this.open = open;
        this.close = close;
        this.duration = duration;
    }

    public void setCloseTime(LocalTime time) {
        if(time.isBefore(open)) {
            throw new IllegalArgumentException("Close time cannot be before open time");
        }
        close = time;
    }

    @Override
    public Iterator<ParkSlot> iterator() {
        return new Iterator<>() {
            private LocalTime current = open;
            private final LocalTime closeTime = close;

            @Override
            public boolean hasNext() {
                return current.isBefore(closeTime);
            }

            @Override
            public ParkSlot next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                LocalTime ans = current;
                current = current.plusMinutes(duration);
                return new ParkSlot(name, ans);
            }
        };
    }
}
