class Order {
    int orderId;
    double baseAmount;
    static double deliveryCharge = 40;

    Order(int orderId, double baseAmount) {
        this.orderId = orderId;
        this.baseAmount = baseAmount;
    }

    double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}

class RegularOrder extends Order {

    RegularOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}

class PremiumOrder extends Order {

    PremiumOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    double calculateBill() {
        double discount = baseAmount * 0.20;
        return baseAmount - discount + deliveryCharge;
    }
}

public class Main {
    public static void main(String[] args) {
        Order o1 = new RegularOrder(101, 500);
        Order o2 = new PremiumOrder(102, 500);

        System.out.println("Regular Order Bill: " + o1.calculateBill());
        System.out.println("Premium Order Bill: " + o2.calculateBill());
    }
}