import java.util.Scanner;

class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();
		System.out.print("Enter second number: ");
        double number2 = input.nextDouble();
		double sum = number1 + number2;
        double difference = number1 - number2;
        double product = number1 * number2;
        double division = number1 / number2;
		System.out.println("Addition = " + sum);
        System.out.println("Subtraction = " + difference);
        System.out.println("Multiplication = " + product);
        System.out.println("Division = " + division);

        input.close();
    }
}
