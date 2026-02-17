import java.util.Scanner;

class SumNaturalNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n > 0) {

            int formulaSum = n * (n + 1) / 2;

            int loopSum = 0;
            int i = 1;

            while (i <= n) {
                loopSum = loopSum + i;
                i++;
            }

            System.out.println("Sum using formula = " + formulaSum);
            System.out.println("Sum using while loop = " + loopSum);

            if (formulaSum == loopSum) {
                System.out.println("Result is correct. Both computations match.");
            } else {
                System.out.println("Result is incorrect. Computations do not match.");
            }

        } else {
            System.out.println("The number " + n + " is not a natural number");
        }

        sc.close();
    }
}

