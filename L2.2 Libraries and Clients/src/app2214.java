public class app2214 {
    public static void main(String[] args) {
        // Simulate random surfer.
        int trials = Integer.parseInt(args[0]);
        double[][] p = StdArrayIO.readDouble2D();
        int n = p.length;
        int page = 0;
        int[] freq = new int[n];
        for (int t = 0; t < trials; t++) { // Make one random move to next page.
            page = StdRandom.discrete(p[page]);
            freq[page]++;
        }
        for (int i = 0; i < n; i++) // Print page ranks.
            StdOut.printf("%8.5f", (double) freq[i] / trials);
        StdOut.println();
    }
}
