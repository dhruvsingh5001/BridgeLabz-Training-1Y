import java.util.*;

class VotingSystem {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();

        String[] castVotes = {"A", "B", "A", "C", "A", "B", "C", "A", "B", "A"};

        for (String v : castVotes) {
            votes.put(v, votes.getOrDefault(v, 0) + 1);
        }

        int max = 0;
        String winner = "";

        for (String key : votes.keySet()) {
            if (votes.get(key) > max) {
                max = votes.get(key);
                winner = key;
            }
        }

        System.out.println("Winner: " + winner);

        for (String key : votes.keySet()) {
            System.out.println(key + ": " + votes.get(key));
        }
    }
}