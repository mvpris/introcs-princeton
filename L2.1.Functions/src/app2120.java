public class app2120 {
    public static void printDeck(String[] deck, int PLAYERS, int CARDS_PER_PLAYER) {
        for (int i = 0; i < CARDS_PER_PLAYER * PLAYERS; i++) {
            System.out.println(deck[i]);
            if (i % CARDS_PER_PLAYER == CARDS_PER_PLAYER - 1)
                System.out.println();
        }
    }

    public static void suffle(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int r = i + (int) (Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    public static String[] initialise(String[] SUITS, String[] RANKS) {
        String[] deck = new String[SUITS.length * RANKS.length];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }

        return deck;
    }

    public static void main(String[] args) {
        int PLAYERS = Integer.parseInt(args[0]);
        int CARDS_PER_PLAYER = 5;
        String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] RANKS =
                {
                        "2", "3", "4", "5", "6", "7", "8", "9", "10",
                        "Jack", "Queen", "King", "Ace"
                };

        String[] deck = initialise(SUITS, RANKS);
        suffle(deck);
        printDeck(deck, PLAYERS, CARDS_PER_PLAYER);
    }
}
