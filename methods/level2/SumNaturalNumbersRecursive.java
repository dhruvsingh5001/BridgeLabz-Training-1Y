import java.util.Scanner;

public class SumNaturalNumbersRecursive {

    public static int sumRecursive(int n) {
        if (n == 1) return 1;
        return n + sumRecursive(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Invalid input. Enter a natural number.");
        } else {
            int sumRec = sumRecursive(n);
            int sumForm = sumFormula(n);

            System.out.println("Sum using recursion: " + sumRec);
            System.out.println("Sum using formula: " + sumForm);

            if (sumRec == sumForm) {
                System.out.println("Both results are correct and equal.");
            } else {
                System.out.println("Results do not match.");
            }
        }

        sc.close();
    }
}
