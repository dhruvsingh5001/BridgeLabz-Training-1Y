public class Main {

    public static <T extends Number> void fib(double n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.println(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        fib(10.9);
    }
}