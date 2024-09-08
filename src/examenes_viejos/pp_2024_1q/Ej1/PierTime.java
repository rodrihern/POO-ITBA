package examenes_viejos.pp_2024_1q.Ej1;

import java.time.LocalTime;

public class PierTime extends Pier {
    private LocalTime open;
    private LocalTime close;

    public PierTime(String name, FerryCompany fc, int capacity, LocalTime open, LocalTime close) {
        super(name, fc, capacity);
        this.open = open;
        this.close = close;
    }

    @Override
    protected boolean canDock(Ferry ferry, LocalTime time) {
        return super.canDock(ferry, time) && time.isAfter(open) && time.isBefore(close);
    }
}
