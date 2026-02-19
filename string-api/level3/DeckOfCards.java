import java.util.Scanner;

public class DeckOfCards {

    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int playersCount, int cardsPerPlayer) {
        if (playersCount * cardsPerPlayer > deck.length) return null;
        String[][] players = new String[playersCount][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < playersCount; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }
        return players;
    }

    public static void printPlayersCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (String card : players[i]) {
                System.out.println("  " + card);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int playersCount = sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = sc.nextInt();

        String[][] players = distributeCards(deck, playersCount, cardsPerPlayer);

        if (players != null) {
            printPlayersCards(players);
        } else {
            System.out.println("Cannot distribute " + cardsPerPlayer + " cards to " + playersCount + " players.");
        }

        sc.close();
    }
}
