import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {

        List<Double> stockPrices = Arrays.asList(
                152.35, 153.10, 151.80, 154.25, 155.00
        );

        stockPrices.forEach(price -> System.out.println("Price: " + price));
    }
}