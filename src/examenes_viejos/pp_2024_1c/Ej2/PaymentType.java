package examenes_viejos.pp_2024_1c.Ej2;

public enum PaymentType {
    BASIC(12) {
        @Override
        public double calculateAmount(int installment, double amount) {
            return amount;
        }
    }
    , FREE_THREE(24) {
        @Override
        public double calculateAmount(int installment, double amount) {
            return installment <= 3 ? 0 : amount;
        }
    }, EVEN_BONIFIED(360) {
        @Override
        public double calculateAmount(int installment, double amount) {
            return installment % 2 == 0 ? amount/2 : amount;
        }
    };

    private final int maxInstallments;

    PaymentType(int maxInstallments) {
        this.maxInstallments = maxInstallments;
    }

    public abstract double calculateAmount(int installment, double amount);

    public boolean isValid(int installments) {
        return installments <= maxInstallments;
    }
}
