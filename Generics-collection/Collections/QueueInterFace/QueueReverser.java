import java.util.*;

class QueueReverser {
    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        int front = queue.remove();
        reverse(queue);
        queue.add(front);
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));

        QueueReverser.reverse(queue);

        System.out.println(queue);
    }
}