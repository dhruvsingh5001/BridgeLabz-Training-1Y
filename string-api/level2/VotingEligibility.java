import java.util.Scanner;
import java.util.Random;

public class VotingEligibility {

    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10; // 2-digit age from 10 to 99
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    public static void displayEligibilityTable(String[][] table) {
        System.out.println("Age\tCan Vote");
        System.out.println("----------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = generateRandomAges(n);
        String[][] eligibility = checkVotingEligibility(ages);
        displayEligibilityTable(eligibility);

        sc.close();
    }
}
