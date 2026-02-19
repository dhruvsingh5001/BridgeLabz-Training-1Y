import java.util.Scanner;

public class CharacterFrequency {

    public static String[][] findCharFrequency(String text) {
        int[] freq = new int[256];
        int length = 0;

        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {}

        for (int i = 0; i < length; i++) {
            freq[text.charAt(i)]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < length; i++) {
            if (freq[text.charAt(i)] != 0) uniqueCount++;
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (freq[ch] != 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                freq[ch] = 0;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] freqData = findCharFrequency(input);

        System.out.println("Character\tFrequency");
        System.out.println("------------------------");
        for (int i = 0; i < freqData.length; i++) {
            System.out.println(freqData[i][0] + "\t\t" + freqData[i][1]);
        }

        sc.close();
    }
}
