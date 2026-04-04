import java.util.*;

public class StudentMarksReport {
    public static void main(String[] args) {
        Object[] marks = {"85", 95, Integer.valueOf(88), "abc", null};

        int sum = 0, count = 0;

        for (Object m : marks) {
            try {
                if (m instanceof String) {
                    int val = Integer.parseInt((String) m);
                    sum += val;
                    count++;
                } else if (m instanceof Integer) {
                    sum += (Integer) m;
                    count++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid mark ignored: " + m);
            }
        }

        double avg = count > 0 ? (double) sum / count : 0;

        System.out.println("Average Marks: " + avg);
    }
}