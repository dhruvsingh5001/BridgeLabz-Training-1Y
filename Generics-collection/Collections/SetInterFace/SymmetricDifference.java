import java.util.*;

class SymmetricDifference {
    public static <T> Set<T> findSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);

        Set<T> temp = new HashSet<>(set1);
        temp.retainAll(set2);

        result.removeAll(temp);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println(SymmetricDifference.findSymmetricDifference(set1, set2));
    }
}