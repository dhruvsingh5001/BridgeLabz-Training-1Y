import java.util.Scanner;

public class GCDLCMCalculator {

    static int takeInput(Scanner sc) {
        return sc.nextInt();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = takeInput(sc);
        int b = takeInput(sc);

        System.out.println("GCD: " + gcd(a, b));
        System.out.println("LCM: " + lcm(a, b));
    }
}