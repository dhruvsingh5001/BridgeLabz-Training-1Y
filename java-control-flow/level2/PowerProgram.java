import java.util.Scanner;

class PowerProgram {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        System.out.print("Enter the power: ");
        int power = sc.nextInt();

        // check positive integers
        if (number < 0 || power < 0) {
            System.out.println("Please enter positive integers only.");
        } else {
            int result = 1;

            for (int i = 1; i <= power; i++) {
                result = result * number;
            }

            System.out.println("Result = " + result);
        }
    }
}
