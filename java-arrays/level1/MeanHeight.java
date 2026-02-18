import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] heights = new double[11];

        System.out.println("Enter heights of 11 players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        double sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        double mean = sum / heights.length;

        System.out.println("\nMean height of the football team = " + mean);

        sc.close();
    }
}
