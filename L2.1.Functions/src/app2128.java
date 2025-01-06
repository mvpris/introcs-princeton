public class app2128 {
    public static double blackScholes(double s, double x, double r, double sigma, double t) {
        double a = (Math.log(s / x) + (r + Math.pow(sigma, 2) / 2) * t) / (sigma * Math.sqrt(t));
        double b = a - sigma / Math.sqrt(t);
        return s * Gaussian.cdf(a) - x * Math.exp(-r * t) * Gaussian.cdf(b);
    }

    public static void main(String[] args) {
        double s = Double.parseDouble(args[0]);
        double x = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        double sigma = Double.parseDouble(args[3]);
        double t = Double.parseDouble(args[4]);
        double result = blackScholes(s, x, r, sigma, t);
        StdOut.println(result);
    }
}
