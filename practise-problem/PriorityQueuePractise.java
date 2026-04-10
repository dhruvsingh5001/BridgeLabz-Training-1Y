import java.util.*;
public class PriorityQueuePractise{
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(56);
        pq.offer(34);
        pq.offer(78);
        pq.offer(22);
        
        System.out.println(pq);
        System.out.println(pq.peek());
        pq.poll();
        System.out.println(pq);
        System.out.println(pq.peek());

    }
}