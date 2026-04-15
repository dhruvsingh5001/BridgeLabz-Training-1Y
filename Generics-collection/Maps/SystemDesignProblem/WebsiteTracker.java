import java.util.*;

class WebsiteTracker {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        String[] visits = {"home", "about", "products", "home", "products", "contact", "home"};

        for (String v : visits) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> e : list) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println("Most visited: " + list.get(0).getKey());
    }
}