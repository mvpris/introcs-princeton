public class app227 {
    public static void plotWithFixedMean(double mean) {
        for (double stdDeviation = 0.5; stdDeviation <= 2.0; stdDeviation += 0.5) {
            plotGaussian(mean, stdDeviation);
        }
    }

    public static void plotWithFixedStandardDeviation(double stdDeviation) {
        for (double mean = -2.0; mean <= 2.0; mean += 0.5) {
            plotGaussian(mean, stdDeviation);
        }
    }

    public static void plotGaussian(double mean, double stdDeviation) {
        int n = 100;
        double[] x = new double[n];
        double[] y = new double[n];
//        StdDraw.setXscale(-10, 10);
//        StdDraw.setYscale(0, 1);

        for (int i = 0; i < n; i++) {
            x[i] = -5.0 + i * 10.0 / (n - 1);
            y[i] = app221.pdf(x[i], mean, stdDeviation);
//            StdDraw.point(x[i], y[i]);
        }
//        StdOut.println(StdStats.min(y));
//        StdOut.println(StdStats.max(y));
        StdStats.plotPoints(y);
        StdDraw.setYscale(0, 1);
    }


    public static void main(String[] args) {
        plotWithFixedMean(0.0);

        plotWithFixedStandardDeviation(1.0);
    }
}
