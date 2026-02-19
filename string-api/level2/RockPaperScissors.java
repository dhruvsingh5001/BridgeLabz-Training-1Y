import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 0.33) return "Rock";
        else if (rand < 0.66) return "Paper";
        else return "Scissors";
    }

    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("Rock") && computer.equals("Scissors")) ||
            (user.equals("Paper") && computer.equals("Rock")) ||
            (user.equals("Scissors") && computer.equals("Paper"))) {
            return "User";
        }
        return "Computer";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int draws, int totalGames) {
        double userPercent = ((double)userWins / totalGames) * 100;
        double compPercent = ((double)computerWins / totalGames) * 100;
        String[][] stats = new String[3][2];
        stats[0][0] = "User Wins"; stats[0][1] = userWins + " (" + String.format("%.2f", userPercent) + "%)";
        stats[1][0] = "Computer Wins"; stats[1][1] = computerWins + " (" + String.format("%.2f", compPercent) + "%)";
        stats[2][0] = "Draws"; stats[2][1] = String.valueOf(draws);
        return stats;
    }

    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("\nGame\tUser\tComputer\tWinner");
        System.out.println("------------------------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i+1) + "\t" + gameResults[i][0] + "\t" + gameResults[i][1] + "\t\t" + gameResults[i][2]);
        }
        System.out.println("\nStatistics:");
        System.out.println("Category\tResult");
        System.out.println("------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[][] gameResults = new String[n][3];
        int userWins = 0, computerWins = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice (Rock/Paper/Scissors) for game " + (i+1) + ": ");
            String userChoice = sc.nextLine();
            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, draws, n);
        displayResults(gameResults, stats);

        sc.close();
    }
}
