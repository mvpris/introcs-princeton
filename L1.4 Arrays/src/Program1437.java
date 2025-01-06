public class Program1437 {
    public static void main(String[] args) {
        int numSimulations = 1000000; // Number of simulations
        int count5332 = 0, count4432 = 0, count4333 = 0;

        for (int i = 0; i < numSimulations; i++) {
            int[] suitCounts = {0, 0, 0, 0}; // Initialize suit counts for 4 suits

            // Deal 13 cards randomly to 4 players
            for (int j = 0; j < 13; j++) {
                int suit = (int) (Math.random() * 4); // Randomly choose a suit (0 to 3)
                suitCounts[suit]++;
            }

            // Check the distribution and increment the corresponding count
            if (suitCounts[0] >= 5 && suitCounts[1] >= 3 && suitCounts[2] >= 3 && suitCounts[3] >= 2) {
                count5332++;
            } else if (suitCounts[0] >= 4 && suitCounts[1] >= 4 && suitCounts[2] >= 3 && suitCounts[3] >= 2) {
                count4432++;
            } else if (suitCounts[0] >= 4 && suitCounts[1] >= 3 && suitCounts[2] >= 3 && suitCounts[3] >= 3) {
                count4333++;
            }
        }

        // Calculate probabilities
        double prob5332 = (double) count5332 / numSimulations;
        double prob4432 = (double) count4432 / numSimulations;
        double prob4333 = (double) count4333 / numSimulations;

        // Print the results
        System.out.println(count5332);
        System.out.println(count4432);
        System.out.println(count4333);
        System.out.println("Probability of 5-3-3-2 distribution: " + prob5332);
        System.out.println("Probability of 4-4-3-2 distribution: " + prob4432);
        System.out.println("Probability of 4-3-3-3 distribution: " + prob4333);
    }
}
