public class app1610 {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        int n = StdIn.readInt();
        StdIn.readInt();
// Read transition matrix.
        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();
// Use the power method to compute page ranks.
        double[] ranks = new double[n];
        ranks[0] = 1.0;
        for (int t = 0; t < trials; t++) { // Compute effect of next move on page ranks.
            double[] newRanks = new double[n];
            for (int j = 0; j < n; j++) { // New rank of page j is dot product
// of old ranks and column j of p[][].
                for (int k = 0; k < n; k++)
                    newRanks[j] += ranks[k] * p[k][j];
            }
            // Update ranks[].
            System.arraycopy(newRanks, 0, ranks, 0, n);
        }

        double maxRank = 0;
        int maxRankPage = 0;
        for (int i = 0; i < n; i++) // Print page ranks.
        {
            if (ranks[i] > maxRank) {
                maxRank = ranks[i];
                maxRankPage = i;
            }
            if (i % 10 == 0 && i != 0) StdOut.println();
            StdOut.printf("%3d%8.5f", i, ranks[i]);
        }
        StdOut.println();
        StdOut.printf("%3d%8.5f\n", maxRankPage, maxRank);

//        Draw histrogram
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(500, 100);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, maxRank + 0.1 * maxRank);
        StdDraw.setPenColor(StdDraw.GRAY);

        for (int i = 0; i < n; i++) {
            StdDraw.filledRectangle(0.5 + i, ranks[i] / 2.0, 0.475, ranks[i] / 2.0);
        }
        StdDraw.show();
        StdDraw.save("medium1610.JPEG");

//        Link added from 23 to 1 gives a decrease of 0.0013
    }
}
