import static java.lang.Math.*;

public class StaticImportDemo {
    public static void main(String[] args) {

        double number = 25;
        double base = 2;
        double exponent = 3;
        int a = -10;
        int b = 20;
        int c = 5;

        double squareRoot = sqrt(number);
        double powerValue = pow(base, exponent);
        int maximum = max(b, c);
        int minimum = min(b, c);
        int absoluteValue = abs(a);

        System.out.println("Square Root of " + number + " = " + squareRoot);
        System.out.println("Power (" + base + "^" + exponent + ") = " + powerValue);
        System.out.println("Maximum of " + b + " and " + c + " = " + maximum);
        System.out.println("Minimum of " + b + " and " + c + " = " + minimum);
        System.out.println("Absolute value of " + a + " = " + absoluteValue);
    }
}
