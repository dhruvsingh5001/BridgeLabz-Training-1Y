import java.util.Scanner;

public class LowerCaseConversion {

    public static String convertToLower(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String builtInLower = input.toLowerCase();
        String userDefinedLower = convertToLower(input);

        System.out.println("Built-in toLowerCase(): " + builtInLower);
        System.out.println("User-defined conversion: " + userDefinedLower);

        boolean isEqual = compareStrings(builtInLower, userDefinedLower);
        System.out.println("Are both conversions equal? " + isEqual);

        sc.close();
    }
}
