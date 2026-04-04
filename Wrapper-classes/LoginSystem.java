import java.util.*;

public class LoginSystem {

    public static boolean isValidAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        String input = sc.nextLine();

        if (isValidAge(input)) {
            System.out.println("Valid age. Signup successful.");
        } else {
            System.out.println("Invalid age. Must be 18+ and numeric.");
        }
    }
}