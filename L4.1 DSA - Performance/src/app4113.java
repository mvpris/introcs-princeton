public class app4113 {
    public static int f(int n) {
        if (n == 0) return 1;
        return f(n - 1) + f(n - 1);
    }

    public static double timeTrial(int n) { // Compute time to solve a random input of size n.
        Stopwatch timer = new Stopwatch();
        f(n);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
//        for (int n = 2; true; n++) {
//            double previous = timeTrial(n - 1);
//            double current = timeTrial(n);
//            double ratio = current / previous;
//            StdOut.printf("%7d %4.2f\n", n, ratio);
//        }

//         Assume you have two arrays: sizes and times
//         sizes[i] is the input size and times[i] is the running time for that input size
        int[] sizes = {22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};
        double[] times = new double[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            times[i] = timeTrial(sizes[i]);
            StdOut.printf("%7d %4.5f\n", sizes[i], times[i]);
        }

//         Convert sizes and times to logarithmic scale for log-log plot
        double[] logSizes = new double[sizes.length];
        double[] logTimes = new double[times.length];
        for (int i = 0; i < sizes.length; i++) {
            logSizes[i] = Math.log(sizes[i]);
            logTimes[i] = Math.log(times[i]);
        }

//         Set the scale of the plot
        StdDraw.setXscale(StdStats.min(logSizes), StdStats.max(logSizes));
        StdDraw.setYscale(StdStats.min(logTimes), StdStats.max(logTimes));

//        Draw the plot
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < logSizes.length - 1; i++) {
//            StdDraw.point(logSizes[i], logTimes[i]);
            StdDraw.line(logSizes[i], logTimes[i], logSizes[i + 1], logTimes[i + 1]);
        }
    }
}
