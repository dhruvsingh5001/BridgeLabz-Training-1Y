class Compare {
    public static <T> boolean isEqual(T a, T b) {
        return a.equals(b);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Compare.isEqual(10, 10));
        System.out.println(Compare.isEqual("Hello", "Hello"));
        System.out.println(Compare.isEqual(5.5, 6.5));
    }
}