import java.util.*;

class BankingSystem {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("A1", 5000.0);
        map.put("A2", 10000.0);
        map.put("A3", 7000.0);

        map.put("A1", map.get("A1") + 2000);

        double withdraw = 8000;
        if (map.get("A2") >= withdraw) {
            map.put("A2", map.get("A2") - withdraw);
        }

        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        for (Map.Entry<String, Double> e : list) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        for (int i = 0; i < Math.min(3, list.size()); i++) {
            System.out.println("Top: " + list.get(i).getKey());
        }
    }
}