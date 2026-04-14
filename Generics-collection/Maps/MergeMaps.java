import java.util.*;

class MergeMaps {
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.put(entry.getKey(),
                    result.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        System.out.println(MergeMaps.mergeMaps(map1, map2));
    }
}