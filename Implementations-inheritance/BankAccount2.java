class BankAccount {
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyInterest() {
        deposit(getBalance() * interestRate / 100);
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA101", 5000, 4.5);
        sa.deposit(1000);
        sa.applyInterest();
        System.out.println("Account: " + sa.getAccountNumber() + ", Balance: " + sa.getBalance());
    }
}
