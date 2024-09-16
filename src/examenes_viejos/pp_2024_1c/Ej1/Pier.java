package examenes_viejos.pp_2024_1c.Ej1;

import java.time.LocalTime;

public class Pier {
    private final String name;
    private final FerryCompany fc;
    private final int capacity;
    private int occupied;


    public Pier(String name, FerryCompany fc, int capacity) {
        this.name = name;
        this.fc = fc;
        this.capacity = capacity;
    }

    protected boolean canDock(Ferry ferry, LocalTime time) {
        return occupied < capacity && fc.equals(ferry.getCompany());
    }

    protected boolean canUndock(Ferry ferry, LocalTime time) {
        return occupied > 0;
    }

    public void dock(Ferry ferry, LocalTime time) {
        if(canDock(ferry, time)) {
            occupied++;
        } else {
            throw new RuntimeException("Unable to dock");
        }
    }

    public void undock(Ferry ferry, LocalTime time) {
        if(canUndock(ferry, time)) {
            occupied--;
        } else {
            throw new RuntimeException("Unable to undock");
        }
    }
}
