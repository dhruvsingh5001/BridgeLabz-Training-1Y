import java.util.*;

class CourseSystem {
    public static void main(String[] args) {
        Map<String, Integer> courses = new HashMap<>();

        courses.put("CS101", 55);
        courses.put("CS102", 3);
        courses.put("CS103", 40);
        courses.put("CS104", 60);
        courses.put("CS105", 2);

        courses.put("CS102", courses.get("CS102") + 1);
        courses.put("CS105", Math.max(0, courses.get("CS105") - 1));

        for (String key : courses.keySet()) {
            if (courses.get(key) >= 50) {
                System.out.println("Full: " + key);
            }
            if (courses.get(key) < 5) {
                System.out.println("Low: " + key);
            }
        }
    }
}