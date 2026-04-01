class Order implements Runnable {
    private int orderId;
    private String restaurant;
    private int deliveryTime;

    public Order(int orderId, String restaurant, int deliveryTime) {
        this.orderId = orderId;
        this.restaurant = restaurant;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        String agent = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();

        try {
            System.out.println("Agent: " + agent + " | Order " + orderId + " from " + restaurant + " | Status: Picked up | Priority: " + priority);
            Thread.sleep(deliveryTime * 1000);

            System.out.println("Agent: " + agent + " | Order " + orderId + " from " + restaurant + " | Status: In Transit | Priority: " + priority);
            Thread.sleep(deliveryTime * 1000);

            System.out.println("Agent: " + agent + " | Order " + orderId + " from " + restaurant + " | Status: Delivered | Priority: " + priority);

            long end = System.currentTimeMillis();
            System.out.println("Order " + orderId + " completed in " + (end - start) / 1000 + " seconds\n");

        } catch (InterruptedException e) {
            System.out.println("Order " + orderId + " interrupted");
        }
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {

        Thread o1 = new Thread(new Order(101, "Pizza Place", 2), "Agent-1");
        Thread o2 = new Thread(new Order(102, "Burger Hub", 3), "Agent-2");
        Thread o3 = new Thread(new Order(103, "Sushi Bar", 2), "Agent-3");
        Thread o4 = new Thread(new Order(104, "Indian Kitchen", 4), "Agent-4");
        Thread o5 = new Thread(new Order(105, "Cafe Delight", 3), "Agent-5");

        o1.setPriority(10);
        o2.setPriority(5);
        o3.setPriority(3);
        o4.setPriority(10);
        o5.setPriority(5);

        o1.start();
        o2.start();
        o3.start();
        o4.start();
        o5.start();
    }
}