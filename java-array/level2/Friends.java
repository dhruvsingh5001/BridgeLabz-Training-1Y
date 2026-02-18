import java.util.Scanner;

class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] name = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        int[] height = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + name[i] + ": ");
            age[i] = sc.nextInt();

            System.out.print("Enter height of " + name[i] + ": ");
            height[i] = sc.nextInt();
        }

        int young = 0, tall = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < age[young])
                young = i;

            if (height[i] > height[tall])
                tall = i;
        }

        System.out.println("Youngest: " + name[young]);
        System.out.println("Tallest: " + name[tall]);
    }
}
