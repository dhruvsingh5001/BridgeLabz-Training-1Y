import java.util.Scanner;

public class StringLengthDemo {

    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int userDefinedLength = findLength(input);
        int builtInLength = input.length();

        System.out.println("Length using user-defined method: " + userDefinedLength);
        System.out.println("Length using built-in method: " + builtInLength);

        sc.close();
    }
}
