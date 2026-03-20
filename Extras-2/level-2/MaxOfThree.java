import java.util.Scanner;

public class MaxOfThree {

    static int[] takeInput(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        return new int[]{a, b, c};
    }

    static int findMax(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = takeInput(sc);
        int max = findMax(nums[0], nums[1], nums[2]);

        System.out.println(max);
    }
}