import java.util.Random;

public class FootballTeamHeight {

    public static int sumHeights(int[] heights) {
        int sum = 0;
        for (int h : heights) sum += h;
        return sum;
    }

    public static double meanHeight(int[] heights) {
        return (double) sumHeights(heights) / heights.length;
    }

    public static int shortestHeight(int[] heights) {
        int min = heights[0];
        for (int h : heights) if (h < min) min = h;
        return min;
    }

    public static int tallestHeight(int[] heights) {
        int max = heights[0];
        for (int h : heights) if (h > max) max = h;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();

        for (int i = 0; i < heights.length; i++) {
            heights[i] = rand.nextInt(101) + 150; // 150 to 250 cm
        }

        System.out.print("Player Heights: ");
        for (int h : heights) System.out.print(h + " ");
        System.out.println();

        System.out.println("Shortest height: " + shortestHeight(heights));
        System.out.println("Tallest height: " + tallestHeight(heights));
        System.out.println("Mean height: " + meanHeight(heights));
    }
}
