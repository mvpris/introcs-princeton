public class Stopwatch3212 {
    private long start;
    private long stop;
    private boolean running;

    public Stopwatch3212() {
        start = System.currentTimeMillis();
        running = true;
    }

    public void stop() {
        stop = System.currentTimeMillis();
        running = false;
    }

    public void restart() {
        start = System.currentTimeMillis();
        running = true;
    }

    public double elapsedTime() {
        long now = running ? System.currentTimeMillis() : stop;
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        Stopwatch3212 timer1 = new Stopwatch3212();
        double sum1 = 0.0;
        for (int i = 1; i <= n; i++)
            sum1 += Math.sqrt(i);
        timer1.stop();

        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum1, time1);

        timer1.restart();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++)
            sum2 += Math.pow(i, 0.5);
        timer1.stop();

        double time2 = timer1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum2, time2);
    }
}
