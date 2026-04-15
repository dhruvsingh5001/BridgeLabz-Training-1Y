import java.util.*;

class InventoryManagement {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();

        stock.put("Milk", 10);
        stock.put("Bread", 5);
        stock.put("Eggs", 20);

        stock.put("Milk", stock.get("Milk") - 10);

        if (stock.get("Milk") <= 0) {
            stock.put("Milk", 0);
        }

        stock.put("Bread", stock.get("Bread") + 10);

        String product = "Milk";
        if (stock.containsKey(product)) {
            System.out.println(product + " left: " + stock.get(product));
        } else {
            System.out.println("not stocked");
        }

        System.out.println("Out of stock:");
        for (String key : stock.keySet()) {
            if (stock.get(key) == 0) {
                System.out.println(key);
            }
        }
    }
}