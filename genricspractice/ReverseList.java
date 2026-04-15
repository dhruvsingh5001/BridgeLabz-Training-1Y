import java.util.*;

public class ReverseList {
    public static void reverseList(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            Integer temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseList(arrayList);
        System.out.println(arrayList);

        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseList(linkedList);
        System.out.println(linkedList);
    }
}