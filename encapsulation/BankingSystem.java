import java.util.ArrayList;
import java.util.List;

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount implements Loanable {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(balance + amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            setBalance(balance - amount);
            System.out.println("Withdrawn: " + amount);
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    private double loanAmountRequested;

    public SavingsAccount(String accNo, String name, double balance, double interestRate) {
        super(accNo, name, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    @Override
    public void applyForLoan(double amount) {
        loanAmountRequested = amount;
        System.out.println("Loan applied for Savings Account: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;
    }
}

class CurrentAccount extends BankAccount {
    private double interestRate;
    private double loanAmountRequested;

    public CurrentAccount(String accNo, String name, double balance, double interestRate) {
        super(accNo, name, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    @Override
    public void applyForLoan(double amount) {
        loanAmountRequested = amount;
        System.out.println("Loan applied for Current Account: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

public class BankingSystem {

    public static void processAccounts(List<BankAccount> accounts) {
        for (BankAccount acc : accounts) {
            acc.displayDetails();

            double interest = acc.calculateInterest();
            System.out.println("Calculated Interest: " + interest);

            acc.deposit(1000);
            acc.withdraw(500);

            acc.applyForLoan(20000);
            boolean eligible = acc.calculateLoanEligibility();
            System.out.println("Loan Eligibility: " + (eligible ? "Eligible" : "Not Eligible"));

            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {

        List<BankAccount> accountList = new ArrayList<>();

        accountList.add(new SavingsAccount("SA101", "Aryan", 8000, 4.0));
        accountList.add(new CurrentAccount("CA202", "Rahul", 15000, 2.5));

        System.out.println("=== Banking System ===\n");

        processAccounts(accountList);
    }
}
