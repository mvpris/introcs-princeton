public class OnePass {
    private int n = 0;
    private double sum = 0.0;
    private double sum2 = 0.0;

    public void add(double value) {
        n++;
        sum = sum + value;
        sum2 = sum2 + value * value;
    }

    public double mean() {
        return sum / n;
    }

    public double variance() {
        return (n * sum2 - sum * sum) / (n * (n - 1));
    }

    public double stddev() {
        return Math.sqrt(variance());
    }

    public static void main(String[] args) {
        OnePass dataset = new OnePass();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            dataset.add(x);
        }

        double mean = dataset.mean();
        double stddev = dataset.stddev();
        double lo = mean - 1.96 * stddev;
        double hi = mean + 1.96 * stddev;

        StdOut.println("mean             = " + mean);
        StdOut.println("sample stddev    = " + stddev);
        StdOut.print("95% approximate confidence interval = ");
        StdOut.println("[ " + lo + ", " + hi + " ]");
    }
}
