import java.util.Arrays;

public class app2226 {

    private static final int NUM_SIMULATIONS = 50000000;

    public static int[] simulatePokerHands() {

        int[] results = new int[9];  // One pair, two pair, three of a kind, full house, flush, straight, straight flush, no hand

        for (int i = 0; i < NUM_SIMULATIONS; i++) {
            int[] hand = generateRandomPokerHand();
            int handType = evaluatePokerHand(hand);
            results[handType]++;
        }

        return results;
    }

    public static int[] generateRandomPokerHand() {
        int[] hand = new int[5];

        for (int i = 0; i < 5; i++) {
            // Assuming a standard deck of 52 cards
            hand[i] = StdRandom.uniformInt(52);
        }

        return hand;
    }

    public static int evaluatePokerHand(int[] hand) {
        Arrays.sort(hand);

        if (isFlush(hand)) {
            if (isStraight(hand)) {
                return 8; // Straight Flush
            }
            return 4; // Flush
        }

        if (isStraight(hand)) {
            return 7; // Straight
        }

        int[] counts = new int[13]; // 13 ranks (2 to Ace)

        for (int card : hand) {
            counts[card % 13]++;  // Get the ranks of cards in hand
        }

        boolean hasPair = false;
        boolean hasTwoPair = false;
        boolean hasThreeOfAKind = false;
        boolean hasFullHouse = false;
        boolean hasFourOfAKind = false;

        for (int count : counts) {
            if (count == 2) {
                if (hasPair) {
                    hasTwoPair = true;
                } else {
                    hasPair = true;
                }
            } else if (count == 3) {
                if (hasPair) {
                    hasFullHouse = true;
                } else {
                    hasThreeOfAKind = true;
                }
            } else if (count == 4) {
                hasFourOfAKind = true;
            }
        }

        if (hasFourOfAKind) {
            return 6; // Four of a Kind
        }

        if (hasFullHouse) {
            return 5; // Full House
        }

        if (hasThreeOfAKind) {
            return 3; // Three of a Kind
        }

        if (hasTwoPair) {
            return 2; // Two Pair
        }

        if (hasPair) {
            return 1; // One Pair
        }

        return 0; // No hand
    }

    public static boolean isFlush(int[] hand) {
        int suit = hand[0] / 13; // Assuming the suit is represented by the integer division result
        for (int card : hand) {
            if (card / 13 != suit) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStraight(int[] hand) {
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i] % 13 != hand[i + 1] % 13 - 1) {
                return false;
            }
        }

        return true;
    }

    public static void printResults(int[] results) {
        StdOut.println("Simulation Results:");

        String[] handTypes = {
                "No Hand", "One Pair", "Two Pair", "Three of a Kind", "Flush",
                "Full House", "Four of a Kind", "Straight", "Straight Flush"
        };

        for (int i = 0; i < results.length; i++) {
            double probability = (double) results[i] * 100 / NUM_SIMULATIONS;
            StdOut.printf("%-15s:\t%.6f\n", handTypes[i], probability);
        }
    }

    public static void main(String[] args) {
        int[] results = simulatePokerHands();
        printResults(results);
    }
}
