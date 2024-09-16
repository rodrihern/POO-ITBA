package examenes_viejos.pp_2023_2c.Ej2;

public class LimitedLaunge extends Lounge {
    private final int max;

    public LimitedLaunge(String name, LoungeCentral central, int max) {
        super(name, central);
        if(max <= 0) {
            throw new IllegalArgumentException();
        }
        this.max = max;
    }

    @Override
    public void enter(Passenger p) {
        if(getGuests() >= max) {
            throw new CannotEnterLoungeException();
        }
        super.enter(p);
    }


    @Override
    public String toString() {
        return super.toString() + " up to %d guests".formatted(max);
    }
}
