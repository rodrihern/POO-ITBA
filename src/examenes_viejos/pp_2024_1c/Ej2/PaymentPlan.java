package examenes_viejos.pp_2024_1c.Ej2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PaymentPlan implements Iterator<PaymentDetail> {

    private final PaymentType type;
    private final double amount;
    private final int installments;
    private int current;


    public PaymentPlan(PaymentType type, double totalAmount, int installments) {
        if(!type.isValid(installments) || totalAmount <= 0 || installments <= 0) {
            throw new InvalidPaymentPlanException();
        }
        this.type = type;
        this.amount = totalAmount / installments;
        this.installments = installments;
        current = 1;
    }



    @Override
    public boolean hasNext() {
        return current <= installments;
    }

    @Override
    public PaymentDetail next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return new PaymentDetail(current, type.calculateAmount(current++, amount));
    }

    public PaymentDetail peek() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return new PaymentDetail(current, type.calculateAmount(current, amount));
    }
}
