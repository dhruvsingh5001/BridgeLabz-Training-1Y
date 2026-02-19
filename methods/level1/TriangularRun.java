import java.util.Scanner;

public class TriangularRun {

    public static int calculateRounds(double side1, double side2, double side3, double totalDistance) {
        double perimeter = side1 + side2 + side3;
        return (int) Math.ceil(totalDistance / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();

        int rounds = calculateRounds(side1, side2, side3, 5000);

        System.out.println("Number of rounds needed: " + rounds);

        sc.close();
    }
}
