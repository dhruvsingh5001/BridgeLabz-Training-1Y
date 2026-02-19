import java.util.Scanner;

public class NumberFormatDemo {

    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException! Invalid number format.");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to parse as number: ");
        String input = sc.nextLine();

        System.out.println("Demonstrating NumberFormatException:");
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        System.out.println("\nHandling NumberFormatException:");
        handleException(input);

        sc.close();
    }
}
