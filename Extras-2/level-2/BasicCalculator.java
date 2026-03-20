import java.util.Scanner;

public class BasicCalculator {

    static double add(double a, double b) {
        return a + b;
    }

    static double subtract(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers:");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();

        System.out.println("Choose operation: +, -, *, /");
        String op = sc.next();

        double result;
        switch (op) {
            case "+": result = add(num1, num2); break;
            case "-": result = subtract(num1, num2); break;
            case "*": result = multiply(num1, num2); break;
            case "/": result = divide(num1, num2); break;
            default: 
                System.out.println("Invalid operation");
                return;
        }

        System.out.println("Result: " + result);
    }
}