class ControlFlows {
    public static void main(String[] args) {

        // While loop
        System.out.println("While loop Example");
        int i = 1;
        while (i <= 20) {
            System.out.println(i);
            i++;
        }

        // Do-While loop
        System.out.println("\nDo-While loop Example");
        int j = 0;
        do {
            System.out.println(j);
            j++;
        } while (j <= 20);

        // For loop pattern
        System.out.println("\nFor loop Pattern Example");
        for (int p = 1; p <= 5; p++) {
            for (int k = 1; k <= 5; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
