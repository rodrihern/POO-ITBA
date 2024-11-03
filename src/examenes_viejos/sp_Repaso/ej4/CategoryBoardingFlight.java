package examenes_viejos.sp_Repaso.ej4;

public class CategoryBoardingFlight extends BoardingFlight {
    public CategoryBoardingFlight() {
        super((p1, p2) -> {
            int cmp = p1.getCategory().compareTo(p2.getCategory());
            if(cmp == 0) {
                cmp = p1.toString().compareTo(p2.toString());
            }
            return cmp;
        });
    }
}
