class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped, Tracking Number: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("O1001", "2026-02-19");
        ShippedOrder order2 = new ShippedOrder("O1002", "2026-02-18", "TRK12345");
        DeliveredOrder order3 = new DeliveredOrder("O1003", "2026-02-17", "TRK54321", "2026-02-19");

        System.out.println(order1.orderId + ": " + order1.getOrderStatus());
        System.out.println(order2.orderId + ": " + order2.getOrderStatus());
        System.out.println(order3.orderId + ": " + order3.getOrderStatus());
    }
}
