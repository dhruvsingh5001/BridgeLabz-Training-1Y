import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String str) {
        System.out.println("Substring: " + str.substring(5, 2));
    }

    public static void handleException(String str) {
        try {
            System.out.println("Substring: " + str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException! Start index is greater than end index.");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Demonstrating IllegalArgumentException:");
        try {
            generateException(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        System.out.println("\nHandling IllegalArgumentException:");
        handleException(input);

        sc.close();
    }
}
