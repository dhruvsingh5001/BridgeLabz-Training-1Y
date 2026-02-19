import java.util.Scanner;

public class ChocolateDistribution {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];
        result[0] = number / divisor;  // chocolates per child
        result[1] = number % divisor;  // remaining chocolates
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfChocolates = sc.nextInt();
        int numberOfChildren = sc.nextInt();

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        System.out.println("Chocolates per child: " + result[0]);
        System.out.println("Remaining chocolates: " + result[1]);

        sc.close();
    }
}
