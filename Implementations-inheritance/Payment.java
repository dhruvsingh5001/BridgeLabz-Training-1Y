interface Payment {
    void pay(double amount);
}

abstract class PaymentMethod implements Payment {
    String accountHolder;

    PaymentMethod(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    abstract public void pay(double amount);

    void displayHolder() {
        System.out.println("Account Holder: " + accountHolder);
    }
}

class CreditCardPayment extends PaymentMethod {
    String cardNumber;

    CreditCardPayment(String accountHolder, String cardNumber) {
        super(accountHolder);
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}

class BankTransferPayment extends PaymentMethod {
    String bankAccount;

    BankTransferPayment(String accountHolder, String bankAccount) {
        super(accountHolder);
        this.bankAccount = bankAccount;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Bank Transfer: " + bankAccount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentMethod credit = new CreditCardPayment("Alice", "1234-5678-9012-3456");
        PaymentMethod bank = new BankTransferPayment("Bob", "9876543210");

        credit.displayHolder();
        credit.pay(250.75);

        bank.displayHolder();
        bank.pay(500.00);
    }
}
