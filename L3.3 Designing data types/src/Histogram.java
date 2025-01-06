public class Histogram {
    private final Counter[] freq;
    private double max;

    public Histogram(int n) { // Create a new histogram.
        freq = new Counter[n];
        for (int i = 0; i < n; i++) {
            freq[i] = new Counter("value " + i, Integer.MAX_VALUE);
        }
    }

    public void addDataPoint(int i) { // Add one occurrence of the value i.
        freq[i].increment();
        if (freq[i].value() > max) max = freq[i].value();
    }

    public void draw() { // Draw (and scale) the histogram.
        StdDraw.setYscale(0, max);
        double[] freqAsDouble = new double[freq.length];
        for (int i = 0; i < freq.length; i++) {
            freqAsDouble[i] = freq[i].value();
        }
        StdStats.plotBars(freqAsDouble);
    }

    public static void main(String[] args) { // See Program 2.2.6.
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        Histogram histogram = new Histogram(n + 1);
        StdDraw.setCanvasSize(500, 200);
        for (int t = 0; t < trials; t++)
            histogram.addDataPoint(Bernoulli.binomial(n));
        histogram.draw();
    }
}
