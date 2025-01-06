import java.awt.*;

public class Histogram3214 {
    private static double[] freq = new double[0];
    private static double max;
    private static double mean;
    private final Draw drawing = new Draw();
    private final int n;
    private final double p;

    public Histogram3214(int n, double p) {
        freq = new double[n];
        this.n = n;
        this.p = p;
    }

    public void addDataPoint(int i) {
        freq[i]++;
        if (freq[i] > max) max = freq[i];
    }

    public void draw() {
        drawing.setCanvasSize(500, 200);
        drawing.setYscale(0, max);
        plotBarsHistogram();
        drawMean();
        draw2StdDev();
    }

    public void plotBarsHistogram() {
        drawing.setXscale(-1, n);
        for (int i = 0; i < n; i++) {
            drawing.filledRectangle(i, freq[i] / 2, 0.25, freq[i] / 2);
        }
    }

    public void drawMean() {
        mean = n * p;
        drawing.setPenColor(Color.RED);
        drawing.line(mean, 0, mean, max);
    }

    public void draw2StdDev() {
        double stddev = Math.sqrt(n * p * (1 - p));
        drawing.setPenColor(Color.BLUE);
        drawing.line(mean - 2 * stddev, 0, mean - 2 * stddev, max);
        drawing.line(mean + 2 * stddev, 0, mean + 2 * stddev, max);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        for (double p = 0.2; p <= 0.8; p += 0.2) {
            Histogram3214 histogram = new Histogram3214(n + 1, p);
            for (int t = 0; t < trials; t++) {
                histogram.addDataPoint(Bernoulli.binomial(n, p));
            }
            histogram.draw();
        }

    }
}
