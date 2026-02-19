import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    public static void generateException(String[] names) {
        System.out.println("Accessing index 10: " + names[10]);
    }

    public static void handleException(String[] names) {
        try {
            System.out.println("Accessing index 10: " + names[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException! Index is out of range.");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        System.out.println("Demonstrating ArrayIndexOutOfBoundsException:");
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        System.out.println("\nHandling ArrayIndexOutOfBoundsException:");
        handleException(names);

        sc.close();
    }
}
