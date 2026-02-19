import java.util.Scanner;

public class TrimStringCharAt {

    public static int[] findTrimIndices(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
        }

        int start = 0;
        while (start < length && text.charAt(start) == ' ') {
            start++;
        }

        int end = length - 1;
        while (end >= 0 && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String substringCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        int len1 = 0, len2 = 0;
        try { while (true) { str1.charAt(len1); len1++; } } catch (IndexOutOfBoundsException e) {}
        try { while (true) { str2.charAt(len2); len2++; } } catch (IndexOutOfBoundsException e) {}
        if (len1 != len2) return false;
        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        int[] indices = findTrimIndices(input);
        String trimmedUser = substringCharAt(input, indices[0], indices[1]);
        String trimmedBuiltIn = input.trim();

        System.out.println("Trimmed using charAt(): \"" + trimmedUser + "\"");
        System.out.println("Trimmed using built-in trim(): \"" + trimmedBuiltIn + "\"");

        boolean isEqual = compareStrings(trimmedUser, trimmedBuiltIn);
        System.out.println("Do both trimmed strings match? " + isEqual);

        sc.close();
    }
}
