class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1001, "Aryan", 5000.0);
        acc.displayAccountDetails();

        acc.setBalance(8000.0);
        System.out.println("\nUpdated Balance: " + acc.getBalance());

        SavingsAccount sa = new SavingsAccount(2001, "Rahul", 10000.0, 4.5);
        System.out.println("\nSavings Account Details:");
        sa.displaySavingsDetails();
    }
}
