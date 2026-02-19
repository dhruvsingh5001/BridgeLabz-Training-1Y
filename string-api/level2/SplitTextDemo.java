import java.util.Scanner;

public class SplitTextDemo {

    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] splitText(String text) {
        int length = findLength(text);
        int wordCount = 1;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndexes = new int[wordCount];
        int spaceIndex = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceIndex++] = i;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount; i++) {
            int end = (i < wordCount - 1) ? spaceIndexes[i] : length;
            String word = "";
            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
            start = end + 1;
        }

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = sc.nextLine();

        String[] builtInWords = input.split(" ");
        String[] userDefinedWords = splitText(input);

        System.out.println("\nWords using built-in split():");
        for (String w : builtInWords) {
            System.out.println(w);
        }

        System.out.println("\nWords using user-defined method:");
        for (String w : userDefinedWords) {
            System.out.println(w);
        }

        boolean isEqual = compareArrays(builtInWords, userDefinedWords);
        System.out.println("\nDo both methods produce the same result? " + isEqual);

        sc.close();
    }
}
