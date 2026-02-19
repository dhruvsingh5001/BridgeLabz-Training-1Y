import java.util.Scanner;

public class UniqueCharFrequency {

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

    public static char[] uniqueCharacters(String text) {
        int length = findLength(text);
        char[] temp = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j] == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[uniqueCount++] = ch;
            }
        }

        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    public static String[][] frequencyOfCharacters(String text) {
        int[] freq = new int[256];
        int length = findLength(text);
        for (int i = 0; i < length; i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniques = uniqueCharacters(text);
        String[][] result = new String[uniques.length][2];
        for (int i = 0; i < uniques.length; i++) {
            result[i][0] = String.valueOf(uniques[i]);
            result[i][1] = String.valueOf(freq[uniques[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] freqData = frequencyOfCharacters(input);

        System.out.println("Character\tFrequency");
        System.out.println("------------------------");
        for (int i = 0; i < freqData.length; i++) {
            System.out.println(freqData[i][0] + "\t\t" + freqData[i][1]);
        }

        sc.close();
    }
}
