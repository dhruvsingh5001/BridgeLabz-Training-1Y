import java.util.*;

class MapUtils {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> result = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            result.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                  .add(entry.getKey());
        }

        return result;
    }

    public static <K> K maxKey(Map<K, Integer> map) {
        K maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);

        Map<Integer, List<String>> inverted = MapUtils.invertMap(input);
        System.out.println(inverted);

        Map<String, Integer> freq = new HashMap<>();
        freq.put("apple", 2);
        freq.put("banana", 5);
        freq.put("orange", 3);

        System.out.println(MapUtils.maxKey(freq));
    }
}