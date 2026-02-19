import java.util.function.Function;
import java.util.Scanner;

public class StringLengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String message = sc.nextLine();

        int limit = 20;

        Function<String, Integer> lengthFunction = s -> s.length();

        int length = lengthFunction.apply(message);

        if (length > limit)
            System.out.println("Message exceeds character limit.");
        else
            System.out.println("Message within limit.");
    }
}
