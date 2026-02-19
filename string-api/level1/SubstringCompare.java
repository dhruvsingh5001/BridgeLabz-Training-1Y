import java.util.Scanner;

public class SubstringCompare {

    public static String createSubstringCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i); 
        }
        return result;
    }

    public static boolean compareStringsCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        if (start < 0 || end > text.length() || start >= end) {
            System.out.println("Invalid indices!");
            sc.close();
            return;
        }

        String subCharAt = createSubstringCharAt(text, start, end);

        String subBuiltin = text.substring(start, end);

        boolean isSame = compareStringsCharAt(subCharAt, subBuiltin);

        System.out.println("\nSubstring using charAt(): " + subCharAt);
        System.out.println("Substring using built-in substring(): " + subBuiltin);
        System.out.println("Both substrings are equal? " + isSame);

        sc.close();
    }
}
