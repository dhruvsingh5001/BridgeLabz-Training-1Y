import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double km = scanner.nextDouble();
        double miles = km * 0.621371;
        System.out.println(km + " km = " + miles + " miles");
        scanner.close();
    }
}
