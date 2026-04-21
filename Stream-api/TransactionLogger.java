import java.util.*;
import java.time.*;

public class TransactionLogger {
    public static void main(String[] args) {

        List<Integer> transactionIds = Arrays.asList(101, 102, 103, 104);

        transactionIds.forEach(id ->
                System.out.println(LocalDateTime.now() + " - Transaction: " + id)
        );
    }
}