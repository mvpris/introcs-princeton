public class app4240 {
    public static double inversePercolation(int n, int trials, double y) {
        return bisectionSearch(n, trials, y, 0.00000001, -2, 2);
    }

    private static double bisectionSearch(int n, int trials, double y, double delta, double lo, double hi) { // Compute x with cdf(x) = y.
        double mid = lo + (hi - lo) / 2;
        if (hi - lo < delta) return mid;
        if (PercolationProbability.estimate(n, mid, trials) > y)
            return bisectionSearch(n, trials, y, delta, lo, mid);
        else
            return bisectionSearch(n, trials, y, delta, mid, hi);
    }

    public static void main(String[] args) {
//        int n = Integer.parseInt(args[0]);
//        double p = Double.parseDouble(args[1]);
//        int trials = Integer.parseInt(args[2]);
        int n = 20;
        double p = 0.6;
        int trials = 10000;
        double q = PercolationProbability.estimate(n, p, trials);
        StdOut.println("q=" + q);
        double inverse = inversePercolation(n, trials, q);
        StdOut.println("inversePercolation=" + inverse);
    }
}
