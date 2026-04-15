import java.util.*;

class DepartmentMapping {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "HR");
        map.put(2, "IT");
        map.put(3, "HR");
        map.put(4, "Finance");

        map.put(2, "HR");

        String dept = "HR";
        for (int key : map.keySet()) {
            if (map.get(key).equals(dept)) {
                System.out.println(key);
            }
        }

        Map<String, Integer> count = new HashMap<>();
        for (String d : map.values()) {
            count.put(d, count.getOrDefault(d, 0) + 1);
        }

        for (String key : count.keySet()) {
            System.out.println(key + " " + count.get(key));
        }
    }
}