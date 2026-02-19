class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    final void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void applyInterest() {
        balance += balance * interestRate / 100;
        System.out.println("Interest applied. New balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA101", 5000, 4.5);
        sa.displayAccountDetails();
        sa.deposit(1000);
        sa.applyInterest();
    }
}
