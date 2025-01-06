public class app161 {
    public static void main(String[] args) {
        double pLeap = Double.parseDouble(args[0]);
        double pLink = 1.0 - pLeap;
        int n = StdIn.readInt();
        int[][] counts = new int[n][n];
        int[] outDegrees = new int[n];
        while (!StdIn.isEmpty()) { // Accumulate link counts.
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            outDegrees[i]++;
            counts[i][j]++;
        }
        StdOut.println(n + " " + n);
        for (int i = 0; i < n; i++) { // Print probability distribution for row i.
            for (int j = 0; j < n; j++) { // Print probability for row i and column j.
                double p = pLink * counts[i][j] / outDegrees[i] + pLeap / n;
                StdOut.printf("%8.5f", p);
            }
            StdOut.println();
        }
    }
}
