public class app2134 {
    public static double binomial(int n, int k, double p) {
        long nFact = 1;
        for (int i = 2; i <= n; i++) {
            nFact *= i;
        }
        long kFact = 1;
        for (int i = 2; i <= k; i++) {
            kFact *= i;
        }
        long nMinusKFact = 1;
        for (int i = 2; i <= n - k; i++) {
            nMinusKFact *= i;
        }

        double x = Math.log(Math.pow(p, k) * Math.pow((1 - p), n - k) * nFact / (kFact * nMinusKFact));
        return Math.exp(x);
    }

    public static double normal(double mu, double sigma, int k) {
        double z = (k - mu) / sigma;
        return Math.exp(-z * z / 2) / (sigma * Math.sqrt(2 * Math.PI));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        double binomialSum = 0.0;
        double normalSum = 0.0;

        for (int k = 0; k <= n; k++) {
            // Binomial probability
            double binomialProb = binomial(n, k, p);
            binomialSum += binomialProb;

            // Normal approximation parameters
            double mu = n * p;
            double sigma = Math.sqrt(n * p * (1 - p));

            // Compute normal approximation for k
            double normal = normal(mu, sigma, k);
            normalSum += normal;

            StdOut.println("k=" + k + ", Binomial=" + binomialProb + ", Normal Approximation=" + normal);
        }

        StdOut.println("Sum of probabilities: " + binomialSum);
        StdOut.println("Sum of normal approximations: " + normalSum);


        // Check that the binomialSum is approximately 1
        if (Math.abs(binomialSum - 1.0) < 1e-10) StdOut.println("Sum is approx 1.");
        else StdOut.println("Sum is not approx 1.");
    }
}
