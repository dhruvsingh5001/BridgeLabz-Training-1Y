import java.util.Scanner;

public class FriendlyPair {

    public static int sumOfDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int sum1 = sumOfDivisors(num1);
        int sum2 = sumOfDivisors(num2);

        if ((double) sum1 / num1 == (double) sum2 / num2) {
            System.out.println("Yes they are a friendly pair");
        } else {
            System.out.println("No they are not a friendly pair");
        }

        sc.close();
    }
}