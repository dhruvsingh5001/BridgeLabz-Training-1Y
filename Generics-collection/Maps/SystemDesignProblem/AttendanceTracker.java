import java.util.*;

class AttendanceTracker {
    public static void main(String[] args) {
        Map<String, Integer> attendance = new HashMap<>();

        String[] students = {"A", "B", "C", "D", "E"};

        for (String s : students) {
            attendance.put(s, 0);
        }

        String[][] days = {
                {"A", "B"}, {"A", "C"}, {"B", "C"}, {"A", "D"}, {"E"},
                {"A"}, {"B"}, {"C"}, {"A"}, {"D"},
                {"E"}, {"A"}, {"B"}, {"C"}, {"A"}
        };

        for (String[] day : days) {
            for (String s : day) {
                attendance.put(s, attendance.get(s) + 1);
            }
        }

        for (String key : attendance.keySet()) {
            if (attendance.get(key) < 10) {
                System.out.println(key);
            }
        }
    }
}