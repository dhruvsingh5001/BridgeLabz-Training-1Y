import java.util.*;

public class EventWelcome {
    public static void main(String[] args) {

        List<String> attendees = Arrays.asList("Aman", "Rahul", "Neha", "Priya");

        attendees.forEach(name -> System.out.println("Welcome " + name));
    }
}