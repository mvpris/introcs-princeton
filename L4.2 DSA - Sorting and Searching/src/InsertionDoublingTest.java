public class InsertionDoublingTest {
    public static double timeTrials(int trials, int n) { // Sort random arrays of size n.
        double total = 0.0;
        Double[] a = new Double[n];
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++)
                a[i] = StdRandom.uniform(0.0, 1.0);
            Stopwatch timer = new Stopwatch();
            Insertion.sort(a);
            total += timer.elapsedTime();
        }
        return total;
    }

    public static void main(String[] args) { // Print doubling ratios for insertion sort.
        int trials = Integer.parseInt(args[0]);
        for (int n = 1024; true; n += n) {
            double prev = timeTrials(trials, n / 2);
            double curr = timeTrials(trials, n);
            double ratio = curr / prev;
            StdOut.printf("%7d %4.2f\n", n, ratio);
        }
    }
}
