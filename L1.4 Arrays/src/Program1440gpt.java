public class Program1440gpt {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java RiffleShuffle <number_of_cards>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        int r = 0; // Number of heads (initialized to 0)

        // Perform n coin flips to determine r
        for (int i = 0; i < n; i++) {
            if (Math.random() < 0.5) {
                r++; // Increment r for each head (probability 0.5)
            }
        }

        // Initialize two piles
        int[] pile1 = new int[r];
        int[] pile2 = new int[n - r];

        // Fill the two piles with cards
        for (int i = 0; i < n; i++) {
            if (i < r) {
                pile1[i] = i + 1; // Cards in pile1: 1, 2, ..., r
            } else {
                pile2[i - r] = i + 1; // Cards in pile2: r+1, r+2, ..., n
            }
        }

        int[] sd = new int[n];
        int ind = 0;

        // Perform the shuffle
        while (pile1[0] != 0 && pile2[0] != 0) {
            double pile1Probability = (double) pile1.length / (pile1.length + pile2.length);
            double pile2Probability = (double) pile2.length / (pile1.length + pile2.length);

            if (Math.random() < pile1Probability) {
                // Take a card from pile1
                sd[ind] = pile1[0];

                // Remove the card from pile1 by shifting elements
                for (int i = 0; i < pile1.length - 1; i++) {
                    pile1[i] = pile1[i + 1];
                }
                pile1[pile1.length - 1] = 0; // Set the last element to 0
            } else {
                // Take a card from pile2
                sd[ind] = pile2[0];

                // Remove the card from pile2 by shifting elements
                for (int i = 0; i < pile2.length - 1; i++) {
                    pile2[i] = pile2[i + 1];
                }
                pile2[pile2.length - 1] = 0; // Set the last element to 0
            }
            ind++;
        }

        System.out.println("index=" + ind);
        System.out.println("pile1 = " + pile1.length + " pile2 = " + pile2.length);
        System.out.print("pile1 ");
        for (int i = 0; i < pile1.length; i++) {
            System.out.print(pile1[i] + " ");
        }
        System.out.println();

        System.out.print("pile2 ");
        for (int i = 0; i < pile2.length; i++) {
            System.out.print(pile2[i] + " ");
        }
        System.out.println();

        // Print the shuffled deck
        for (int card : sd) {
            System.out.print(card + " ");
        }
        System.out.println();

        // Complete shuffling for the last cards which did not get shuffled
        int y = 0;
        for (int i = 0; i < n; i++) {
            if (sd[i] != 0) y++;
        }

        System.out.println("y=" + y);
        while (y != 52 && sd[y] == 0) {
            if (pile1[0] != 0) {
                sd[y] = pile1[0];
                for (int i = 0; i < pile1.length - 1; i++) {
                    pile1[i] = pile1[i + 1];
                }
            }
            if (pile2[0] != 0) {
                sd[y] = pile2[0];
                for (int i = 0; i < pile2.length - 1; i++) {
                    pile2[i] = pile2[i + 1];
                }
            }
            y++;
        }

        // Print the final shuffled deck
        for (int card : sd) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
