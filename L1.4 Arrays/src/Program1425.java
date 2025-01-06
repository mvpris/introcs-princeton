public class Program1425 {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        int[][] shuffleCountTable = new int[m][m];

        for (int k = 0; k < n; k++) {
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = i;
            }

            // Shuffle the deck with random integers between 0 and n-1
            for (int i = 0; i < m; i++) {
                int r = (int) (Math.random() * m); // Choose a random integer between 0 and n-1
                int temp = a[i];
                a[i] = a[r];
                a[r] = temp;
            }

            // Update the count table
            for (int i = 0; i < m; i++) {
                int value = a[i];
                shuffleCountTable[value][i]++;
            }
        }

        // Print the count table
        System.out.println("Shuffling Results (m = " + m + ", n = " + n + "):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                double frequency = (double) shuffleCountTable[i][j] / n;
                System.out.printf("%.2f\t", frequency);
            }
            System.out.println();
        }
    }
}
