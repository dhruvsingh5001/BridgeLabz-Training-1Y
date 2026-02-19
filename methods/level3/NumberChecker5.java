import java.util.Scanner;

public class NumberChecker5 {

    public static int sumProperDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum;
    }

    public static boolean isPerfect(int n) {
        return n > 0 && sumProperDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        return sumProperDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        return sumProperDivisors(n) < n;
    }

    public static int factorial(int d) {
        int fact = 1;
        for (int i = 1; i <= d; i++) fact *= i;
        return fact;
    }

    public static boolean isStrong(int n) {
        int temp = n;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        System.out.println("Perfect: " + isPerfect(number));
        System.out.println("Abundant: " + isAbundant(number));
        System.out.println("Deficient: " + isDeficient(number));
        System.out.println("Strong: " + isStrong(number));

        sc.close();
    }
}
