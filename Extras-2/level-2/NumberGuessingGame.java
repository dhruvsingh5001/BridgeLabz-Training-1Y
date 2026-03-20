import java.util.Scanner;

public class NumberGuessingGame {

    static int generateGuess(int low, int high) {
        return low + (int)(Math.random() * (high - low + 1));
    }

    static String getFeedback(Scanner sc, int guess) {
        System.out.println("Is your number " + guess + "? (high/low/correct)");
        return sc.nextLine().toLowerCase();
    }

    static int[] updateRange(int low, int high, int guess, String feedback) {
        if (feedback.equals("high")) {
            high = guess - 1;
        } else if (feedback.equals("low")) {
            low = guess + 1;
        }
        return new int[]{low, high};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;

        while (true) {
            int guess = generateGuess(low, high);
            String feedback = getFeedback(sc, guess);

            if (feedback.equals("correct")) {
                System.out.println("Guessed correctly!");
                break;
            }

            int[] range = updateRange(low, high, guess, feedback);
            low = range[0];
            high = range[1];
        }
    }
}