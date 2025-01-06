public class app1619 {
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
        double nn = Math.sqrt(n);
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(-maxRank, 2 * nn * maxRank + maxRank);
        StdDraw.setYscale(-maxRank, 2 * nn * maxRank + maxRank);
        StdDraw.setPenColor(StdDraw.GRAY);

        int cc = 0;
        for (int i = 0; i < nn; i++) {
            for (int j = 0; j < nn; j++) {
                if (cc == n) break;
                StdDraw.filledCircle(2 * j * maxRank, 2 * i * maxRank, ranks[cc]);
                cc++;
            }
        }
        StdDraw.show();

    }
}
