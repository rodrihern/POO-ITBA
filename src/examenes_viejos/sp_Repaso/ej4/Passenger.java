package examenes_viejos.sp_Repaso.ej4;

public class Passenger {
    private final String name;
    private final int row;
    private final PassengerCategory category;


    public Passenger(String name, int row, PassengerCategory category) {
        this.name = name;
        this.row = row;
        this.category = category;

    }

    public int getRow() {
        return row;
    }

    public PassengerCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name;
    }
}
