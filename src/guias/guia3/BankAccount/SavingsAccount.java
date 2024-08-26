package guias.guia3.BankAccount;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(int id) {
        super(id);
    }

    @Override
    protected boolean canExtract(double amount) {
        return getBalance() >= amount;
    }
}
