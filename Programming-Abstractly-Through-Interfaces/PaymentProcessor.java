interface PaymentProcessor {
    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Refund of " + amount + " processed using default method.");
    }
}

class PayPal implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via PayPal.");
    }
}

class Stripe implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Stripe.");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {

        PaymentProcessor p1 = new PayPal();
        PaymentProcessor p2 = new Stripe();

        p1.pay(1000);
        p1.refund(200);

        p2.pay(1500);
        p2.refund(300);
    }
}
