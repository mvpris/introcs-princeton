public class Gaussian { // Implement Gaussian (normal) distribution functions.
    public static double pdf(double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    public static double pdf(double x, double mu, double sigma) {
        return pdf((x - mu) / sigma) / sigma;
    }

    public static double cdf(double z) {
        if (z < -8.0) return 0.0;
        if (z > 8.0) return 1.0;
        double sum = 0.0;
        double term = z;
        for (int i = 3; sum != sum + term; i += 2) {
            sum = sum + term;
            term = term * z * z / i;
        }
        return 0.5 + pdf(z) * sum;
    }

    public static double cdf(double z, double mu, double sigma) {
        return cdf((z - mu) / sigma);
    }

    public static double inversePDF(double y) {
        return bisectionSearchPDF(y, 0.00000001, -8, 8);
    }

    private static double bisectionSearchPDF(double y, double delta,
                                             double lo, double hi) {
        // Compute x with cdf(x) = y.
        double mid = lo + (hi - lo) / 2;
        if (hi - lo < delta) return mid;
        if (pdf(mid) > y)
            return bisectionSearchPDF(y, delta, lo, mid);
        else
            return bisectionSearchPDF(y, delta, mid, hi);
    }

    public static double inverseCDF(double y) {
        return bisectionSearch(y, 0.00000001, -8, 8);
    }

    private static double bisectionSearch(double y, double delta,
                                          double lo, double hi) {
        // Compute x with cdf(x) = y.
        double mid = lo + (hi - lo) / 2;
        if (hi - lo < delta) return mid;
        if (cdf(mid) > y)
            return bisectionSearch(y, delta, lo, mid);
        else
            return bisectionSearch(y, delta, mid, hi);
    }

    public static void main(String[] args) {
        double z = Double.parseDouble(args[0]);
//        double mu = Double.parseDouble(args[1]);
//        double sigma = Double.parseDouble(args[2]);
        StdOut.printf("pdf(%.10f) = %.10f\n", z, pdf(z));
        StdOut.printf("pdf^(-1)(%.10f) = %.10f\n", z, inversePDF(pdf(z)));
        StdOut.println();
        StdOut.printf("cdf(%.10f) = %.10f\n", z, cdf(z));
        StdOut.printf("cdf^(-1)(%.10f) = %.10f\n", z, inverseCDF(cdf(z)));

//        java Gaussian 1.5683947453
//        pdf(1.5683947453) = 0.1166159092
//        pdf^(-1)(1.5683947453) = -1.5683947466
//
//        cdf(1.5683947453) = 0.9416054817
//        cdf^(-1)(1.5683947453) = 1.5683947466

//        Accurate to 8 significant digits
    }
}
