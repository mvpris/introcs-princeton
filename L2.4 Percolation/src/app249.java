public class app249 {
    public static double estimate(int n, double p, int trials) {
        int count = 0;
        int[] freq = new int[trials + 1];
        for (int t = 0; t < trials; t++) {
            boolean[][] isOpen = Percolation.random(n, p);
            if (Percolation.percolates(isOpen)) count++;
            freq[count]++;
        }
        double[] norm = new double[trials + 1];
        for (int i = 0; i <= trials; i++)
            norm[i] = (double) freq[i] / trials;
        StdStats.plotBars(norm);
        double mean = trials / 2.0;
        double stddev = Math.sqrt(trials) / 2.0;
        double[] phi = new double[trials + 1];
        for (int i = 0; i <= trials; i++)
            phi[i] = Gaussian.pdf(i, mean, stddev);
        StdStats.plotLines(phi);
        return (double) count / trials;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        int trials = Integer.parseInt(args[2]);
        double q = estimate(n, p, trials);
        StdOut.println(q);
    }
}
