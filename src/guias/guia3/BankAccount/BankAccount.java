package guias.guia3.BankAccount;

public abstract class BankAccount {
    private int id;
    private double balance;

    public BankAccount(int id) {
        this.id = id;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    protected abstract boolean canExtract(double amount);

    public void extract(double amount) {
        if(canExtract(amount)) {
            balance -= amount;
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }

    @Override
    public String toString() {
        return "Cuenta %d con saldo %.2f".formatted(id, balance);
    }

    protected double getBalance() {
        return balance;
    }
}
