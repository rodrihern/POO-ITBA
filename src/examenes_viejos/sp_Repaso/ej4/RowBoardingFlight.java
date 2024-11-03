package examenes_viejos.sp_Repaso.ej4;

public class RowBoardingFlight extends BoardingFlight{
    public RowBoardingFlight() {
        super((p1, p2) -> {
            int cmp = p1.getRow() - p2.getRow();
            if(cmp == 0) {
                cmp = p1.toString().compareTo(p2.toString());
            }
            return cmp;
        });
    }
}
