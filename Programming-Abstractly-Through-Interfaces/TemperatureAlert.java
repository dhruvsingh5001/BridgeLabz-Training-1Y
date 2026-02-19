import java.util.function.Predicate;
import java.util.Scanner;

public class TemperatureAlert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();

        double threshold = 37.5;

        Predicate<Double> isHigh = t -> t > threshold;

        if (isHigh.test(temp))
            System.out.println("Alert! Temperature crossed threshold.");
        else
            System.out.println("Temperature is normal.");
    }
}
