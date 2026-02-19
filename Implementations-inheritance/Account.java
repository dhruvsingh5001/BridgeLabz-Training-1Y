class Account {
    private String accountId;
    private double balance;

    Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void displayAccount() {
        System.out.println("Account ID: " + accountId + ", Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    SavingsAccount(String accountId, double balance, double interestRate) {
        super(accountId, balance);
        this.interestRate = interestRate;
    }

    void applyInterest() {
        deposit(getBalance() * interestRate / 100);
    }

    @Override
    void displayAccount() {
        super.displayAccount();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        Account acc = new Account("AC1001", 5000);
        SavingsAccount sa = new SavingsAccount("AC1002", 8000, 4.5);

        acc.displayAccount();
        acc.deposit(1000);
        acc.withdraw(2000);
        acc.displayAccount();

        sa.displayAccount();
        sa.applyInterest();
        sa.deposit(500);
        sa.withdraw(1000);
        sa.displayAccount();
    }
}
