import java.util.*;

class SetToSortedList {
    public static List<Integer> convert(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> sortedList = SetToSortedList.convert(set);
        System.out.println(sortedList);
    }
}