import java.util.Scanner;

public class NumberChecker {

    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] storeDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) return true;
        }
        return false;
    }

    public static boolean isArmstrong(int[] digits) {
        int n = digits.length;
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, n);
        }
        int number = 0;
        for (int d : digits) number = number * 10 + d;
        return sum == number;
    }

    public static int[] largestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] smallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int digitCount = countDigits(number);
        int[] digits = storeDigits(number);

        System.out.println("Number of digits: " + digitCount);
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();

        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrong(digits));

        int[] largest = largestAndSecondLargest(digits);
        System.out.println("Largest: " + largest[0] + ", Second Largest: " + largest[1]);

        int[] smallest = smallestAndSecondSmallest(digits);
        System.out.println("Smallest: " + smallest[0] + ", Second Smallest: " + smallest[1]);

        sc.close();
    }
}
