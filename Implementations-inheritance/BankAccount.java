class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountType() {
        System.out.println("Generic Bank Account");
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("Savings Account -> Account Number: " + accountNumber + ", Balance: " + balance + ", Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayAccountType() {
        System.out.println("Checking Account -> Account Number: " + accountNumber + ", Balance: " + balance + ", Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int maturityPeriod; // in months

    FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    @Override
    void displayAccountType() {
        System.out.println("Fixed Deposit Account -> Account Number: " + accountNumber + ", Balance: " + balance + ", Maturity Period: " + maturityPeriod + " months");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount sa = new SavingsAccount("SA123", 5000, 4.5);
        BankAccount ca = new CheckingAccount("CA456", 3000, 1000);
        BankAccount fd = new FixedDepositAccount("FD789", 10000, 12);

        sa.displayAccountType();
        ca.displayAccountType();
        fd.displayAccountType();
    }
}
