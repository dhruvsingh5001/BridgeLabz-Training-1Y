import java.util.Scanner;

public class PalindromeCheck {

    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }

    // Logic 1: Iterative check using start and end indexes
    public static boolean isPalindromeIterative(String text) {
        int length = findLength(text);
        int start = 0;
        int end = length - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive method
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using character array and reversal
    public static char[] reverseString(String text) {
        int length = findLength(text);
        char[] rev = new char[length];
        for (int i = 0; i < length; i++) {
            rev[i] = text.charAt(length - 1 - i);
        }
        return rev;
    }

    public static boolean isPalindromeCharArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to check palindrome: ");
        String input = sc.nextLine();

        boolean result1 = isPalindromeIterative(input);
        boolean result2 = isPalindromeRecursive(input, 0, findLength(input) - 1);
        boolean result3 = isPalindromeCharArray(input);

        System.out.println("Palindrome check using iterative logic: " + result1);
        System.out.println("Palindrome check using recursive logic: " + result2);
        System.out.println("Palindrome check using char array logic: " + result3);

        sc.close();
    }
}
