package examenes_viejos.pp_2023_2c.Ej1;

import java.time.LocalTime;

public class ParkSlot {

    private final String attraction;
    LocalTime time;

    public ParkSlot(String attraction, LocalTime time) {
        this.attraction = attraction;
        this.time = time;
    }

    @Override
    public String toString() {
        return "%s <> %s Slot".formatted(attraction, time);
    }
}
