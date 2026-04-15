import java.util.*;

class CountryCapital {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();

        map.put("India", "Delhi");
        map.put("USA", "Washington");
        map.put("UK", "London");
        map.put("France", "Paris");
        map.put("Japan", "Tokyo");
        map.put("China", "Beijing");
        map.put("Russia", "Moscow");
        map.put("Germany", "Berlin");

        String country = "India";
        System.out.println(map.getOrDefault(country, "Unknown country"));

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}