import java.util.Scanner;

public class \ {

    public static char[] getChars(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.next(); 

        char[] charsUser = getChars(text);

        char[] charsBuiltin = text.toCharArray();

        boolean isSame = compareCharArrays(charsUser, charsBuiltin);

        System.out.println("\nCharacters from user-defined method:");
        for (char c : charsUser) System.out.print(c + " ");
        System.out.println();

        System.out.println("\nCharacters from built-in toCharArray():");
        for (char c : charsBuiltin) System.out.print(c + " ");
        System.out.println();

        System.out.println("\nAre both arrays equal? " + isSame);

        sc.close();
    }
}
