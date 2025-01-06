public class app154 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double sum1 = 0;
        double sum2 = 0;
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = StdIn.readDouble();
            sum1 += x[i];
        }
        double mean = sum1 / n;
        for (int i = 0; i < n; i++) {
            sum2 += Math.pow(x[i] - mean, 2);
        }
        double stdDev = Math.sqrt(sum2 / (n - 1));
        StdOut.println("mean=" + mean);
        StdOut.println("standard deviation=" + stdDev);
        double dev = 1.5 * stdDev;
        StdOut.println("1.5 standard deviations=" + dev);
        StdOut.print("Numbers more than 1.5 standard deviations away from mean: ");
        for (int i = 0; i < n; i++) {
            if (Math.abs(x[i] - mean) > dev) {
                StdOut.print(x[i] + " ");
            }
        }
        StdOut.println();
    }
}
