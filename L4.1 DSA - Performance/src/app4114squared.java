public class app4114squared {
    public static double timeTrial(int n) { // Compute time to solve a random input of size n.
        Stopwatch timer = new Stopwatch();
        Coupon.collectCoupons(n);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for (int n = 4096; n > 0 && n <= Integer.MAX_VALUE / 2; n = n * n) { // Print doubling ratio for problem size n.
            double previous = timeTrial(n / 2);
            double current = timeTrial(n);
            double ratio = current / previous;
            StdOut.printf("%7d %4.2f\n", n, ratio);
        }
//        results:
//        4096 1.00
//        16777216 3.46
    }
}
