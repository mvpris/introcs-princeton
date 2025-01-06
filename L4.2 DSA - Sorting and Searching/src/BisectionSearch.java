public class BisectionSearch {
    public static double inverseCDF(double y) {
        return bisectionSearch(y, 0.00000001, -8, 8);
    }

    private static double bisectionSearch(double y, double delta, double lo, double hi) { // Compute x with cdf(x) = y.
        double mid = lo + (hi - lo) / 2;
        if (hi - lo < delta) return mid;
        if (Gaussian.cdf(mid) > y)
            return bisectionSearch(y, delta, lo, mid);
        else
            return bisectionSearch(y, delta, mid, hi);
    }

    public static void main(String[] args) {
        double y = Double.parseDouble(args[0]);
        double inverse = inverseCDF(y);
        StdOut.println("inverseCDF=" + inverse);
    }
}
