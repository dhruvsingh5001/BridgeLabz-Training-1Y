import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void generateException(String str) {
        System.out.println("Character at index 10: " + str.charAt(10));
    }

    public static void handleException(String str) {
        try {
            System.out.println("Character at index 10: " + str.charAt(10));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException! Index is out of range.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Demonstrating StringIndexOutOfBoundsException:");
        try {
            generateException(input);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        System.out.println("\nHandling StringIndexOutOfBoundsException:");
        handleException(input);

        sc.close();
    }
}
