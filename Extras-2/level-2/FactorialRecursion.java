import java.util.Scanner;

public class FactorialRecursion {

    static int takeInput(Scanner sc) {
        return sc.nextInt();
    }

    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    static void displayResult(long result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = takeInput(sc);
        long result = factorial(n);
        displayResult(result);
    }
}