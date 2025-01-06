public class Program1440 {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]); // Number of cards
        int r = 0; // Number of heads (initialized to 0)

        // Perform n coin flips to determine r
        for (int i = 0; i < n; i++) {
            if (Math.random() < 0.5) {
                r++; // Increment r for each head (probability 0.5)
            }
        }
        int u = n - r; // u,,, r=r

        // Initialize two piles
        int[] pile1 = new int[r];
        int[] pile2 = new int[u];

        // Fill the two piles with cards
        for (int i = 0; i < n; i++) {
            if (i < r) {
                pile1[i] = i + 1; // Cards in pile1: 1, 2, ..., r
            } else {
                pile2[i - r] = i + 1; // Cards in pile2: r+1, r+2, ..., n
            }
        }

        // Initialize shuffled deck
        int[] sd = new int[n];
        int ind = 0;

        // Perform the shuffle
        while (pile1[0] != 0 && pile2[0] != 0) {
            double pile1Probability = (double) r / (r + u);
            double pile2Probability = (double) u / (r + u);

            if (Math.random() < pile1Probability) {
                // Take a card from pile1
                sd[ind] = pile1[0];
                // Remove the card from pile1 by shifting elements
                for (int i = 0; i < r - 1; i++) {
                    pile1[i] = pile1[i + 1];
                }
                pile1[r - 1] = 0; // Set the last element to 0
            } else {
                // Take a card from pile2
                sd[ind] = pile2[0];
                // Remove the card from pile2 by shifting elements
                for (int i = 0; i < u - 1; i++) {
                    pile2[i] = pile2[i + 1];
                }
                pile2[u - 1] = 0; // Set the last element to 0
            }

            ind++;
        }

        // (TRACE) Print index, pile1, pile2 after intermediary manipulation
        System.out.println("FIRST SHUFFLE WITH TRACE:");
        System.out.println("index=" + ind);
        System.out.println("pile1 = " + r + " pile2 = " + u);
        System.out.print("pile1: ");
        for (int i = 0; i < r; i++) {
            System.out.print(pile1[i] + " ");
        }
        System.out.println();

        System.out.print("pile2: ");
        for (int i = 0; i < u; i++) {
            System.out.print(pile2[i] + " ");
        }
        System.out.println();

        // Print the intermediary shuffled deck
        for (int card : sd) {
            System.out.print(card + " ");
        }
        System.out.println();

        // Complete shuffling for the last cards which did not get shuffled
        int y = ind;
        while (y != n && sd[y] == 0) {
            if (pile1[0] != 0) {
                sd[y] = pile1[0];
                for (int i = 0; i < r - 1; i++) {
                    pile1[i] = pile1[i + 1];
                }
            }
            if (pile2[0] != 0) {
                sd[y] = pile2[0];
                for (int i = 0; i < u - 1; i++) {
                    pile2[i] = pile2[i + 1];
                }
            }
            y++;
        }

        // (TRACE) Print pile1,pile2 after final manipulation
        System.out.print("pile1: ");
        for (int i = 0; i < r; i++) {
            System.out.print(pile1[i] + " ");
        }
        System.out.println();

        System.out.print("pile2: ");
        for (int i = 0; i < u; i++) {
            System.out.print(pile2[i] + " ");
        }
        System.out.println();
        // Print the final shuffled deck
        for (int card : sd) {
            System.out.print(card + " ");
        }
        System.out.println();
        System.out.println();

        /////////////////////////////////////////////////////////////////////////////////////////////
        // A doua parte nu e buna, nu stiu ce are, ultimele valori le copiaza aiurea, dau duplicate cateodata

        int m = Integer.parseInt(args[1]);
        for (int x = 0; x < m; x++) {
            r = 0; // Number of heads (initialized to 0)

            // Perform n coin flips to determine r
            for (int i = 0; i < n; i++) {
                if (Math.random() < 0.5) {
                    r++; // Increment r for each head (probability 0.5)
                }
            }
            u = n - r; // u,,, r=r

            // Initialize two piles
            int[] pile1n = new int[r];
            int[] pile2n = new int[u];

            // Fill the two piles with cards
            for (int i = 0; i < n; i++) {
                if (i < r) {
                    pile1n[i] = sd[i]; // Cards in pile1: 1, 2, ..., r
                } else {
                    pile2n[i - r] = sd[i]; // Cards in pile2: r+1, r+2, ..., n
                }
            }

//          // (TRACE) Fill (copy from sd[i] to pile1n,pile2n)
//            System.out.print("r=" + r + " u=" + u);
//            System.out.println();
//            for (int i = 0; i < r; i++) {
//                System.out.print(pile1n[i] + " ");
//            }
//            System.out.println();
//            for (int i = 0; i < u; i++) {
//                System.out.print(pile2n[i] + " ");
//            }
//            System.out.println();

            ind = 0;

            // Perform the shuffle
            while (pile1n[0] != 0 && pile2n[0] != 0) {
                double pile1Probability = (double) r / (r + u);
                double pile2Probability = (double) u / (r + u);

                if (Math.random() < pile1Probability) {
                    // Take a card from pile1
                    sd[ind] = pile1n[0];
                    // Remove the card from pile1 by shifting elements
                    for (int i = 0; i < r - 1; i++) {
                        pile1n[i] = pile1n[i + 1];
                    }
                    pile1n[r - 1] = 0; // Set the last element to 0
                } else {
                    // Take a card from pile2
                    sd[ind] = pile2n[0];
                    // Remove the card from pile2 by shifting elements
                    for (int i = 0; i < u - 1; i++) {
                        pile2n[i] = pile2n[i + 1];
                    }
                    pile2n[u - 1] = 0; // Set the last element to 0
                }

                ind++;
            }
//
//            // (TRACE) Print index, pile1, pile2 after intermediary manipulation
//            System.out.println("index=" + ind);
//            System.out.println("pile1n = " + r + " pile2n = " + u);
//            System.out.print("pile1n: ");
//            for (int i = 0; i < r; i++) {
//                System.out.print(pile1n[i] + " ");
//            }
//            System.out.println();
//
//            System.out.print("pile2n: ");
//            for (int i = 0; i < u; i++) {
//                System.out.print(pile2n[i] + " ");
//            }
//            System.out.println();
//
//            // Print the intermediary shuffled deck
//            for (int card : sd) {
//                System.out.print(card + " ");
//            }
//            System.out.println();
//
//            // Complete shuffling for the last cards which did not get shuffled
//            y = ind;
//            while (y != n && sd[y] == 0) {
//                if (pile1n[0] != 0) {
//                    sd[y] = pile1n[0];
//                    for (int i = 0; i < r - 1; i++) {
//                        pile1n[i] = pile1n[i + 1];
//                    }
//                }
//                if (pile2n[0] != 0) {
//                    sd[y] = pile2n[0];
//                    for (int i = 0; i < u - 1; i++) {
//                        pile2n[i] = pile2n[i + 1];
//                    }
//                }
//                y++;
//            }
//
//            // (TRACE) Print pile1,pile2 after final manipulation
//            System.out.print("pile1n: ");
//            for (int i = 0; i < r; i++) {
//                System.out.print(pile1n[i] + " ");
//            }
//            System.out.println();
//
//            System.out.print("pile2n: ");
//            for (int i = 0; i < u; i++) {
//                System.out.print(pile2n[i] + " ");
//            }
//            System.out.println();

            // Print the final shuffled deck
            for (int card : sd) {
                System.out.print(card + " ");
            }
            System.out.println();

        }


    }
}
