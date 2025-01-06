public class app4239 {
    public static double blackScholes(double s, double x, double r, double sigma, double t) {
        double a = aTerm(s, x, r, sigma, t);
        double b = bTerm(a, sigma, t);
        return s * Gaussian.cdf(a) - x * Math.exp(-r * t) * Gaussian.cdf(b);
    }

    public static double aTerm(double s, double x, double r, double sigma, double t) {
        return (Math.log(s / x) + (r + Math.pow(sigma, 2) / 2) * t) / (sigma * Math.sqrt(t));
    }


    public static double bTerm(double a, double sigma, double t) {
        return a - sigma / Math.sqrt(t);
    }

    public static double inverseBS(double s, double x, double r, double t, double y) {
        return bisectionSearch(s, x, r, t, y, 1E-08, -50, 50);
    }

    private static double bisectionSearch(double s, double x, double r, double t,
                                          double y, double delta, double lo, double hi) { // Compute x with cdf(x) = y.
        double mid = lo + (hi - lo) / 2;
        if (hi - lo < delta) return mid;
        if (blackScholes(s, x, r, mid, t) > y)
            return bisectionSearch(s, x, r, t, y, delta, lo, mid);
        else
            return bisectionSearch(s, x, r, t, y, delta, mid, hi);
    }

    public static void main(String[] args) {
//        double s = Double.parseDouble(args[0]);
//        double x = Double.parseDouble(args[1]);
//        double r = Double.parseDouble(args[2]);
//        double sigma = Double.parseDouble(args[3]);
//        double t = Double.parseDouble(args[4]);
        double s = 100.0;
        double x = 105.0;
        double r = 0.05;
        double sigma = 0.2;
        double t = 1.0;
        double result = blackScholes(s, x, r, sigma, t);
        StdOut.println("Black-Scholes value = " + result);
        double inverseResult = inverseBS(s, x, r, t, result);
        StdOut.println("Black-Scholes sigma = " + inverseResult);
    }
}
