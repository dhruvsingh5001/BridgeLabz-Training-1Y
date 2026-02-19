import java.util.Scanner;

public class VowelsConsonantsTable {

    public static String checkChar(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static String[][] analyzeString(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
        }

        String[][] result = new String[length][2];
        for (int i = 0; i < length; i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkChar(text.charAt(i));
        }
        return result;
    }

    public static void displayTable(String[][] table) {
        System.out.println("Character\tType");
        System.out.println("----------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] analysis = analyzeString(input);
        displayTable(analysis);

        sc.close();
    }
}
