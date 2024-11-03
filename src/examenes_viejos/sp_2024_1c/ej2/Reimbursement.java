package examenes_viejos.sp_2024_1c.ej2;

import java.time.YearMonth;

public class Reimbursement {
    private final int amount;
    private final YearMonth ym;

    public Reimbursement(YearMonth ym, int amount) {
        this.ym = ym;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public YearMonth getYm() {
        return ym;
    }
}
