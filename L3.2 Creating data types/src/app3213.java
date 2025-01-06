public class app3213 {
    public static double harmonic(int n) {
        if (n == 1) return 1.0;
        return harmonic(n - 1) + 1.0 / n;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        Stopwatch3212 timer1 = new Stopwatch3212();
        double sum1 = 0.0;
        for (int i = 1; i <= n; i++)
            sum1 += 1.0 / i;
        timer1.stop();

        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.6f seconds)\n", sum1, time1);

        timer1.restart();
        double sum2 = harmonic(n);
        timer1.stop();

        double time2 = timer1.elapsedTime();
        StdOut.printf("%e (%.6f seconds)\n", sum2, time2);
    }
}
