package guias.guia5.LocalDateInterval;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LocalDateInterval implements Iterable<LocalDate> {
    private final LocalDate first, last;
    private final int step;

    public LocalDateInterval(LocalDate first, LocalDate last, int step) {
        this.first = first;
        this.last = last;
        this.step = step;
    }

    @Override
    public Iterator<LocalDate> iterator() {
        return new LocalDateIterator();
    }

    private
    class LocalDateIterator implements Iterator<LocalDate> {

        private LocalDate current = first;

        @Override
        public boolean hasNext() {
            return !current.isAfter(last);
        }

        @Override
        public LocalDate next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            LocalDate ans = current;
            current = current.plusDays(step);
            return ans;
        }
    }

}
