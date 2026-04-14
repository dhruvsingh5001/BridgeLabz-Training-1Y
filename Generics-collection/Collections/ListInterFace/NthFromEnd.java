import java.util.*;

class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        int count = 0;
        while (fast.hasNext()) {
            fast.next();
            count++;
            if (count > n) {
                slow.next();
            }
        }

        return slow.next();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println(NthFromEnd.findNthFromEnd(list, 2));
    }
}