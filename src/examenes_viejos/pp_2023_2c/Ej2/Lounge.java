package examenes_viejos.pp_2023_2c.Ej2;

public class Lounge {
    private final String name;
    private final LoungeCentral central;
    private int guests;

    public Lounge(String name, LoungeCentral central) {
        if(name == null || central == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.central = central;
        guests = 0;
    }

    public int getGuests() {
        return guests;
    }

    public void enter(Passenger p) {
        if(!central.isOpen()) {
            throw new CannotEnterLoungeException();
        }
        p.usePass();
        guests++;
    }

    public void exit() {
        if(guests <= 0) {
            throw new EmptyLaungeException();
        }
        guests--;
    }

    public void exit(int passengers) {
        if(guests < passengers) {
            throw new EmptyLaungeException();
        }
        guests -= passengers;
    }

    @Override
    public String toString() {
        return "%s has %d guests".formatted(name, guests);
    }
}
