import java.util.Scanner;

public class ShortestLongestWord {

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
        int wordCount = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && (i == 0 || text.charAt(i - 1) == ' ')) {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int index = 0;
        int start = -1;

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch != ' ' && start == -1) {
                start = i;
            }
            if ((ch == ' ' || i == length - 1) && start != -1) {
                int end = (ch == ' ') ? i : i + 1;
                String word = "";
                for (int j = start; j < end; j++) {
                    word += text.charAt(j);
                }
                words[index++] = word;
                start = -1;
            }
        }
        return words;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static String[] findShortestLongest(String[][] words2D) {
        if (words2D.length == 0) return new String[]{"", ""};

        String shortest = words2D[0][0];
        String longest = words2D[0][0];
        int minLen = Integer.parseInt(words2D[0][1]);
        int maxLen = Integer.parseInt(words2D[0][1]);

        for (int i = 1; i < words2D.length; i++) {
            int len = Integer.parseInt(words2D[i][1]);
            if (len < minLen) {
                minLen = len;
                shortest = words2D[i][0];
            }
            if (len > maxLen) {
                maxLen = len;
                longest = words2D[i][0];
            }
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = sc.nextLine();

        String[] words = splitText(input);
        String[][] words2D = wordsWithLengths(words);
        String[] shortestLongest = findShortestLongest(words2D);

        System.out.println("\nWord\tLength");
        System.out.println("---------------");
        for (int i = 0; i < words2D.length; i++) {
            String word = words2D[i][0];
            int length = Integer.parseInt(words2D[i][1]);
            System.out.println(word + "\t" + length);
        }

        System.out.println("\nShortest word: " + shortestLongest[0]);
        System.out.println("Longest word: " + shortestLongest[1]);

        sc.close();
    }
}
