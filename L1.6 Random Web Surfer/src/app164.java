public class app164 {
    public static void main(String[] args) {
// Simulate random surfer.
        int trials = Integer.parseInt(args[0]);
        int n = StdIn.readInt();
        StdIn.readInt();
// Read transition matrix.
        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();
        int page = 0;
        int[] freq = new int[n];
        for (int t = 0; t < trials; t++) { // Make one random move to next page.
            double r = Math.random();
            double sum = 0.0;
            for (int j = 0; j < n; j++) {
                sum += p[page][j];
            }

// Check if the sum of probabilities is close to 1, allowing for a small margin of error (epsilon).
            double epsilon = 1E-10;
            if (Math.abs(1.0 - sum) > epsilon) {
                // The probabilities don't add up to 1, so normalize them.
                for (int j = 0; j < n; j++) {
                    p[page][j] /= sum;
                }
            }

// Generate the random move based on the normalized probabilities.
            sum = 0.0;
            for (int j = 0; j < n; j++) {
                sum += p[page][j];
                if (r < sum) {
                    page = j;
                    break;
                }
            }
            freq[page]++;
        }
        for (int i = 0; i < n; i++) // Print page ranks.
            StdOut.printf("%8.5f", (double) freq[i] / trials);
        StdOut.println();
    }
}
