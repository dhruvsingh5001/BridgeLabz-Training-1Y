import java.util.Scanner;
import java.util.Arrays;

public class NumberChecker {

    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] storeDigits(int number) {
        String s = String.valueOf(Math.abs(number));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return rev;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return arraysEqual(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Digits: " + Arrays.toString(digits));

        int[] reversed = reverseArray(digits);
        System.out.println("Reversed digits: " + Arrays.toString(reversed));

        System.out.println("Arrays equal: " + arraysEqual(digits, reversed));
        System.out.println("Is Palindrome: " + isPalindrome(digits));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));

        sc.close();
    }
}
