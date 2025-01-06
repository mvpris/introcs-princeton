public class app4115 {
    public static void markov(int trials) {
        In in = new In("Transition.txt");
        int n = in.readInt();
        in.readInt();

// Read transition matrix.
        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = in.readDouble();

// Use the power method to compute page ranks.
        double[] ranks = new double[n];
        ranks[0] = 1.0;
        for (int t = 0; t < trials; t++) {
            // Compute effect of next move on page ranks.
            double[] newRanks = new double[n];
            for (int j = 0; j < n; j++) {
                // New rank of page j is dot product of old ranks and column j of p[][].
                for (int k = 0; k < n; k++)
                    newRanks[j] += ranks[k] * p[k][j];
            }
            for (int j = 0; j < n; j++) // Update ranks[].
                ranks[j] = newRanks[j];
        }
//        for (int i = 0; i < n; i++) // Print page ranks.
//            StdOut.printf("%8.5f", ranks[i]);
//        StdOut.println();
    }

    public static double timeTrial(int n) { // Compute time to solve a random input of size n.
        Stopwatch timer = new Stopwatch();
        markov(n);
        return timer.elapsedTime();
    }

    public static double[] sizes(int n, int startValue) {
        double[] sizes = new double[n];
        sizes[0] = startValue;
        for (int i = 1; i < n; i++) {
            sizes[i] = sizes[i - 1] * 2;
        }
        return sizes;
    }

    public static double[] times(double[] sizes) {
        StdOut.println("Times:");
        double[] times = new double[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            times[i] = timeTrial((int) sizes[i]);
            StdOut.printf("%8d %4.3f\n", (int) sizes[i], times[i]);
        }
        return times;
    }

    public static void draw(double[] sizes, double[] times) {
        double[] logSizes = new double[sizes.length];
        double[] logTimes = new double[times.length];
        for (int i = 0; i < sizes.length; i++) {
            logSizes[i] = Math.log(sizes[i]);
            logTimes[i] = Math.log(times[i]);
        }
        StdDraw.setXscale(StdStats.min(logSizes), StdStats.max(logSizes));
        StdDraw.setYscale(StdStats.min(logTimes), StdStats.max(logTimes));
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < sizes.length - 1; i++) {
            StdDraw.line(logSizes[i], logTimes[i], logSizes[i + 1], logTimes[i + 1]);
        }
    }

    public static void ratios(double[] sizes, double[] times) {
        StdOut.println("Ratios:");
        for (int i = 1; i < times.length; i++) {
            double ratio = times[i] / times[i - 1];
            StdOut.printf("%8d %4.2f\n", (int) sizes[i], ratio);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int startValue = Integer.parseInt(args[1]);
        double[] sizes = sizes(n, startValue);
        double[] times = times(sizes);
        ratios(sizes, times);
        draw(sizes, times);
    }
}
