import java.util.Scanner;

public class FrequencyNestedLoops {

    public static String[][] frequencyUsingNestedLoops(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {}

        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = text.charAt(i);
        }

        int[] freq = new int[length];
        for (int i = 0; i < length; i++) {
            if (chars[i] == '0') continue;
            freq[i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') count++;
        }

        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                result[index][0] = String.valueOf(chars[i]);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] freqData = frequencyUsingNestedLoops(input);

        System.out.println("Character\tFrequency");
        System.out.println("------------------------");
        for (int i = 0; i < freqData.length; i++) {
            System.out.println(freqData[i][0] + "\t\t" + freqData[i][1]);
        }

        sc.close();
    }
}
