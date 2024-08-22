package taller.taller3;

public abstract class SubwayCard {
    private SubwayCentral sc;

    public SubwayCard(SubwayCentral sc) {
        this.sc = sc;
    }


    protected abstract boolean canRide();

    protected SubwayCentral getSubwayCentral() {
        return sc;
    }

    public abstract void ride();
}
