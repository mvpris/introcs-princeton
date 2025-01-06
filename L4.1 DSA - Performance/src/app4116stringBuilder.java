public class app4116stringBuilder {
    public static void stringBuild(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (StdRandom.bernoulli(0.5)) sb.append("0");
            else sb.append("1");
        String s = sb.toString();
    }

    public static double timeTrial(int n) { // Compute time to solve a random input of size n.
        Stopwatch timer = new Stopwatch();
        stringBuild(n);
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

