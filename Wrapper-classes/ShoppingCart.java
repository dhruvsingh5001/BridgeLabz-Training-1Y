import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        String[] prices = {"250", "499", "99", "abc", "100"};
        
        int total = 0;

        for (String price : prices) {
            try {
                int value = Integer.parseInt(price);
                total += value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price ignored: " + price);
            }
        }

        System.out.println("Total Price: " + total);
    }
}