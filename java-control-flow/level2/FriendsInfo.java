import java.util.Scanner;

class FriendsInfo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();

        System.out.print("Enter Amar's height: ");
        double amarHeight = sc.nextDouble();

        System.out.print("Enter Akbar's height: ");
        double akbarHeight = sc.nextDouble();

        System.out.print("Enter Anthony's height: ");
        double anthonyHeight = sc.nextDouble();

        String youngest;
        int minAge = amarAge;

        youngest = "Amar";

        if (akbarAge < minAge) {
            minAge = akbarAge;
            youngest = "Akbar";
        }
        if (anthonyAge < minAge) {
            minAge = anthonyAge;
            youngest = "Anthony";
        }

        String tallest;
        double maxHeight = amarHeight;

        tallest = "Amar";

        if (akbarHeight > maxHeight) {
            maxHeight = akbarHeight;
            tallest = "Akbar";
        }
        if (anthonyHeight > maxHeight) {
            maxHeight = anthonyHeight;
            tallest = "Anthony";
        }

        System.out.println("Youngest friend: " + youngest);
        System.out.println("Tallest friend: " + tallest);
    }
}
