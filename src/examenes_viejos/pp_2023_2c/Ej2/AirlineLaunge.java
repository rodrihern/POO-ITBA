package examenes_viejos.pp_2023_2c.Ej2;

public class AirlineLaunge extends LimitedLaunge{
    private final String airline;

    public AirlineLaunge(String name, LoungeCentral central, int max, String airline) {
        super(name, central, max);
        if(airline == null) {
            throw new IllegalArgumentException();
        }
        this.airline = airline;
    }

    @Override
    public void enter(Passenger p) {
        if(!airline.equals(p.getAirline())) {
            throw new CannotEnterLoungeException();
        }
        super.enter(p);
    }

    @Override
    public String toString() {
        return airline + " " + super.toString();
    }

}
