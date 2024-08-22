package taller.taller3;

public class DiscountRechargeableSubwayCard extends RechargeableSubwayCard {
    private double discountPercentaje;

    DiscountRechargeableSubwayCard(SubwayCentral sc, double dp) {
        super(sc);
        discountPercentaje = dp;
    }

    @Override
    protected double rideCost() {
        return super.rideCost() * discountPercentaje;
    }
}
