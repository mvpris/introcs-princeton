public class app4136 {
    public static int maxSumSubArray(int[] a, int m) {
        int windowSum = 0;
        int maxSum = 0;

        for (int i = 0; i < m; i++) {
            windowSum += a[i];
        }
        maxSum = windowSum;

        for (int i = m; i < a.length; i++) {
            windowSum = windowSum - a[i - m] + a[i];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }

    public static int[] randomArrayGenerator(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(n);
        }
        return a;
    }

    public static double timeTrial(int[] a, int m) {
        Stopwatch timer = new Stopwatch();
        maxSumSubArray(a, m);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
//        int[] a = {4, 2, 3, 5, 8, 2, 4};
//        int m = 4;
//        int maxSum = maxSumSubArray(a, m);
//        StdOut.println("MaxSum = " + maxSum);

        int m = Integer.parseInt(args[0]);
        for (int n = 1048576; true; n *= 2) {
            int[] a = randomArrayGenerator(n);
            double previous = timeTrial(a, n / 2);
            double current = timeTrial(a, n);
            double ratio = current / previous;
            StdOut.printf("%7d %4.2f\n", n, ratio);
        }
    }
}
