public class app2328 {
    private static double[][] cache = new double[101][51];

    public static long binomialBottomUpWEBSITE(int n, int k) {
        long[][] binomial = new long[n + 1][k + 1];

        // base cases
        for (int i = 0; i <= n; i++) binomial[i][0] = 1;
        for (int j = 1; j <= k; j++) binomial[0][j] = 0;

        // bottom-up dynamic programming
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= k; j++)
                binomial[i][j] = binomial[i - 1][j] + binomial[i - 1][j - 1];

        return binomial[n][k];
    }

    public static double binomialBottomUp(int n, int k) {
        double[][] cache2 = new double[n + 1][k + 1];
        cache2[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            cache2[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                cache2[i][j] = cache2[i - 1][j] + cache2[i - 1][j - 1];
            }
        }
        return cache2[n][k];
    }


    public static double binomialTopDown(int n, int k) {
        if ((n == 0) && (k == 0)) return 1.0;
        if ((n < 0) || (k < 0)) return 0.0;
        else if (cache[n][k] == 0) {
            cache[n][k] = binomialTopDown(n - 1, k) + binomialTopDown(n - 1, k - 1);
        }
        return cache[n][k];
    }

    public static double binomialInefficient(int n, int k) {
        if ((n == 0) && (k == 0)) return 1.0;
        if ((n < 0) || (k < 0)) return 0.0;
        return binomialInefficient(n - 1, k) + binomialInefficient(n - 1, k - 1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(binomialBottomUpWEBSITE(n, k));
        StdOut.println(binomialBottomUp(n, k));
        StdOut.println(binomialTopDown(n, k));
//        StdOut.println(binomialInefficient(n, k));
    }
}
