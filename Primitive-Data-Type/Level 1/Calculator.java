import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();

        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "
                + num1 + " and " + num2 + " is "
                + (num1 + num2) + ", "
                + (num1 - num2) + ", "
                + (num1 * num2) + ", "
                + (num1 / num2));
    }
}
