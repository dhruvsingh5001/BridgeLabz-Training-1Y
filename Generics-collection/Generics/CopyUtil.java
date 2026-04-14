import java.util.*;

class CopyUtil {
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number n : src) {
            dest.add(n);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Number> dest = new ArrayList<>();
        List<Integer> srcInt = Arrays.asList(1, 2, 3);
        List<Double> srcDouble = Arrays.asList(1.1, 2.2, 3.3);

        CopyUtil.copyList(dest, srcInt);
        CopyUtil.copyList(dest, srcDouble);

        System.out.println(dest);
    }
}