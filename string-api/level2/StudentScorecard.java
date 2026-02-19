import java.util.Scanner;
import java.util.Random;

public class StudentScorecard {

    public static int[][] generateRandomScores(int students) {
        int[][] scores = new int[students][3];
        Random rand = new Random();
        for (int i = 0; i < students; i++) {
            scores[i][0] = rand.nextInt(91) + 10; // Physics 10-100
            scores[i][1] = rand.nextInt(91) + 10; // Chemistry 10-100
            scores[i][2] = rand.nextInt(91) + 10; // Maths 10-100
        }
        return scores;
    }

    public static double[][] calculateTotalsPercentages(int[][] scores) {
        int students = scores.length;
        double[][] result = new double[students][3];
        for (int i = 0; i < students; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3;
            double percent = (total / 300) * 100;
            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    public static String[] calculateGrades(double[][] percentages) {
        String[] grades = new String[percentages.length];
        for (int i = 0; i < percentages.length; i++) {
            double percent = percentages[i][2];
            if (percent >= 90) grades[i] = "A+";
            else if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B+";
            else if (percent >= 60) grades[i] = "B";
            else if (percent >= 50) grades[i] = "C";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] totals, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i+1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2] 
                + "\t" + totals[i][0] + "\t" + totals[i][1] + "\t" + totals[i][2] + "\t\t" + grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateRandomScores(n);
        double[][] totalsPercent = calculateTotalsPercentages(scores);
        String[] grades = calculateGrades(totalsPercent);
        displayScorecard(scores, totalsPercent, grades);

        sc.close();
    }
}
