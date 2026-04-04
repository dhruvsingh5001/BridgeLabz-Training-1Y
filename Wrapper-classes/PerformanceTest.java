import java.util.*;

public class PerformanceTest {
    public static void main(String[] args) {
        int n = 1_000_000;

        long start, end;

        int[] arr = new int[n];
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        long sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i];
        }
        end = System.nanoTime();
        long timeArray = end - start;

        ArrayList<Integer> list = new ArrayList<>();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        long sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum2 += list.get(i);
        }
        end = System.nanoTime();
        long timeList = end - start;

        System.out.println("Array sum: " + sum1 + " Time: " + timeArray);
        System.out.println("ArrayList sum: " + sum2 + " Time: " + timeList);
    }
}