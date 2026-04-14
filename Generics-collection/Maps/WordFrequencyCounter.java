import java.util.*;
import java.io.*;

class WordFrequencyCounter {
    public static Map<String, Integer> countWords(String fileName) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.toLowerCase().replaceAll("[^a-z ]", "");
            String[] words = line.split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }

        br.close();
        return map;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> result = WordFrequencyCounter.countWords("input.txt");
        System.out.println(result);
    }
}