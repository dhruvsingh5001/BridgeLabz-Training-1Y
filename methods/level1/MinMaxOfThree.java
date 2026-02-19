import java.util.Scanner;

public class MinMaxOfThree {

    public static void findMinMax(int a, int b, int c) {
        int smallest = a;
        int largest = a;

        if (b < smallest) smallest = b;
        if (c < smallest) smallest = c;

        if (b > largest) largest = b;
        if (c > largest) largest = c;

        System.out.println("Smallest: " + smallest);
        System.out.println("Largest: " + largest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        findMinMax(num1, num2, num3);

        sc.close();
    }
}
