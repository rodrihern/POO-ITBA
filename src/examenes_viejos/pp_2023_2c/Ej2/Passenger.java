package examenes_viejos.pp_2023_2c.Ej2;

public class Passenger {
    private final String name;
    private final String airline;
    private int passes;

    public Passenger(String name, String airline, int passes) {
        this.name = name;
        this.airline = airline;
        this.passes = passes;
    }

    public boolean hasPass() {
        return passes > 0;
    }

    public void usePass() {
        if(!hasPass()) {
            throw new CannotEnterLoungeException();
        }
        passes--;
    }

    public String getAirline() {
        return airline;
    }

    public String getName() {
        return name;
    }
}
