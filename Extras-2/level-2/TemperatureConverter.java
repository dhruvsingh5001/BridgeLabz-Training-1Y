import java.util.Scanner;

public class TemperatureConverter {

    static double celsiusToFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5/9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double temp = sc.nextDouble();
        String unit = sc.next();

        if (unit.equalsIgnoreCase("C")) {
            System.out.println(celsiusToFahrenheit(temp));
        } else if (unit.equalsIgnoreCase("F")) {
            System.out.println(fahrenheitToCelsius(temp));
        } else {
            System.out.println("Invalid unit");
        }
    }
}