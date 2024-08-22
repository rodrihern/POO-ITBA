package taller.taller3;

public class RechargeableSubwayCard extends SubwayCard {
    private double balance;

    RechargeableSubwayCard(SubwayCentral sc) {
        super(sc);
    }

    public void recharge(double amount) {
        balance += amount;
    }

    protected double rideCost() {
        SubwayCentral sc = getSubwayCentral();
        return sc.getRideCost();
    }

    @Override
    protected boolean canRide() {
        return balance >= rideCost();
    }

    @Override
    public void ride() {
        if(canRide()) {
            SubwayCentral sc = getSubwayCentral();
            balance -= rideCost();
        }
        else {
            System.out.println("No se puede viajar");
        }
    }
}
