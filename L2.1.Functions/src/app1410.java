public class app1410 {
    public static void main(String[] args) {
        int PLAYERS = Integer.parseInt(args[0]);
        int CARDS_PER_PLAYER = 5;
        String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] RANKS =
                {
                        "2", "3", "4", "5", "6", "7", "8", "9", "10",
                        "Jack", "Queen", "King", "Ace"
                };

        int n = SUITS.length * RANKS.length;

//        throw exception if too many hands are required to be given
        if (CARDS_PER_PLAYER * PLAYERS > n) {
            throw new RuntimeException("Too many players");
        }

//        initialise deck
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length * i + j] = RANKS[i] + " " + SUITS[j];
            }
        }

//        shuffle deck
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }

//        print shuffled deck
        for (int i = 0; i < CARDS_PER_PLAYER * PLAYERS; i++) {
            System.out.println(deck[i]);
            if (i % CARDS_PER_PLAYER == CARDS_PER_PLAYER - 1)
                System.out.println();
        }
    }
}
