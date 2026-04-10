// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class Main1 {
    public static void main(String[] args) {

Queue<Integer> q=new LinkedList<>();
q.add(56);
q.add(45);
q.add(51);
q.offer(66);
q.offer(92);
System.out.println(q);
System.out.println(q.peek());
System.out.println(q.element());

q.remove();
q.poll();
System.out.println(q);
System.out.println(q.size());
System.out.println(q.contains(66));

    }
}