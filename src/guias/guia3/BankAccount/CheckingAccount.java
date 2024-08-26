package guias.guia3.BankAccount;

public class CheckingAccount extends BankAccount {
    private double overdraft;

    public CheckingAccount(int id, double overdraft) {
        super(id);
        this.overdraft = overdraft;
    }

    @Override
    protected boolean canExtract(double amount) {
        return getBalance() + overdraft >= amount;
    }

    double getOverdraft() {
        return overdraft;
    }
}
