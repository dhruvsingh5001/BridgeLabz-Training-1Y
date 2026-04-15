import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Map<String, Double> grades = new HashMap<>();

        grades.put("Alice", 85.5);
        grades.put("Bob", 78.0);
        grades.put("Carol", 92.3);
        grades.put("David", 88.8);

        grades.put("Bob", 82.5);

        grades.remove("David");

        Map<String, Double> sorted = new TreeMap<>(grades);

        for (Map.Entry<String, Double> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}