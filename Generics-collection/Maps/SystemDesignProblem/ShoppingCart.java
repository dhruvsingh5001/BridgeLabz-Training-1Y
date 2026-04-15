import java.util.*;

class ShoppingCart {
    public static void main(String[] args) {
        Map<String, Double> cart = new LinkedHashMap<>();

        cart.put("Laptop", 4000.0);
        cart.put("Phone", 2000.0);
        cart.put("Headphones", 500.0);

        double total = 0;
        for (double v : cart.values()) {
            total += v;
        }

        if (total > 5000) {
            total *= 0.9;
        }

        cart.remove("Headphones");

        for (String key : cart.keySet()) {
            System.out.println(key + " " + cart.get(key));
        }

        System.out.println("Total: " + total);
    }
}