import java.util.*;

public class ProductRatingsAnalyzer {
    public static void main(String[] args) {
        int[] ratingsArray = {4, 5, 3, 4};
        ArrayList<Integer> ratingsList = new ArrayList<>(Arrays.asList(5, null, 4, 3));

        ArrayList<Integer> combined = new ArrayList<>();

        for (int r : ratingsArray) {
            combined.add(r);
        }

        combined.addAll(ratingsList);

        int sum = 0, count = 0;

        for (Integer r : combined) {
            if (Objects.nonNull(r)) {
                sum += r;
                count++;
            }
        }

        double avg = count > 0 ? (double) sum / count : 0;

        System.out.println("Combined Ratings: " + combined);
        System.out.println("Average Rating: " + avg);
    }
}