package examenes_viejos.pp_2024_1q_ej1;

import java.time.LocalTime;

public class PierTimeStack extends PierTime{
    private Ferry last;

    public PierTimeStack(String name, FerryCompany fc, int capacity, LocalTime open, LocalTime close) {
        super(name, fc, capacity, open, close);
    }

    @Override
    protected boolean canUndock(Ferry ferry, LocalTime time) {
        return super.canUndock(ferry, time) && ferry.equals(last);
    }

    @Override
    public void dock(Ferry ferry, LocalTime time) {
        super.dock(ferry, time);
        last = ferry;
    }

    @Override
    public void undock(Ferry ferry, LocalTime time) {
        super.undock(ferry, time);
        last = null;
    }



}
