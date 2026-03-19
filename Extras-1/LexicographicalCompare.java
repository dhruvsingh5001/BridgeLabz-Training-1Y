import java.util.Scanner;

public class LexicographicalCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;

        while (i < minLength) {
            if (s1.charAt(i) < s2.charAt(i)) {
                System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
                return;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\" in lexicographical order");
                return;
            }
            i++;
        }

        if (s1.length() < s2.length()) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
        } else if (s1.length() > s2.length()) {
            System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }
    }
}