import java.util.*;

class ExamResults {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> map = new HashMap<>();

        Map<String, Integer> math = new HashMap<>();
        math.put("A", 95);
        math.put("B", 80);

        Map<String, Integer> sci = new HashMap<>();
        sci.put("A", 85);
        sci.put("B", 92);

        map.put("Math", math);
        map.put("Science", sci);

        for (String subject : map.keySet()) {
            Map<String, Integer> m = map.get(subject);

            int max = 0;
            int sum = 0;

            for (int v : m.values()) {
                sum += v;
                if (v > max) max = v;
            }

            System.out.println(subject + " Top: " + max);
            System.out.println(subject + " Avg: " + (sum / m.size()));

            if (max > 90) {
                System.out.println(subject + " has score above 90");
            }
        }
    }
}