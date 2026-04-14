import java.util.*;

class SumUtil {
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10, 20, 30);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);

        System.out.println(SumUtil.sumNumbers(intList));
        System.out.println(SumUtil.sumNumbers(doubleList));
    }
}