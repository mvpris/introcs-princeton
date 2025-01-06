public class DoublingTest {
    public static double timeTrial(int n) { // Compute time to solve a random input of size n.
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniformInt(2000000) - 1000000;
        Stopwatch timer = new Stopwatch();
        int count = ThreeSum.countTriples(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) { // Print table of doubling ratios.
        for (int n = 512; true; n *= 2) { // Print doubling ratio for problem size n.
            double previous = timeTrial(n / 2);
            double current = timeTrial(n);
            double ratio = current / previous;
            StdOut.printf("%7d %4.2f\n", n, ratio);
        }
    }
}
