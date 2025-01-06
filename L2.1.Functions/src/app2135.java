public class app2135 {
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

        return Math.pow(p, k) * Math.pow((1 - p), n - k) * nFact / (kFact * nMinusKFact);
    }

    public static int getCoupon(int n, double p) {
        double x = Math.random();
        double sum = 0.0;
        int k = 0;

        while (sum < x) {
            sum += binomial(n, k, p);
            k++;
        }

        return k - 1;
    }

    public static int collectCoupons(int n) {
        boolean[] isCollected = new boolean[n];
        int count = 0;
        int distinct = 1;

        while (distinct < n) {
            int r = getCoupon(n, 0.5); // Assuming p = 1/2
            count++;

            if (!isCollected[r]) {
                distinct++;
                isCollected[r] = true;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = collectCoupons(n);
        StdOut.println(count);
    }
}
