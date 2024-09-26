package taller.taller7.BoardingFlight;

public class Passenger {
    private final String name;
    private final int row;
    private final PassengerCategory category;


    public Passenger(String name, int row, PassengerCategory category) {
        this.name = name;
        this.row = row;
        this.category = category;
    }

    public PassengerCategory getCategory() {
        return category;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return name;
    }
}
