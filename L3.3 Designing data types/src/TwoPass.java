public class TwoPass {
    private int capacity = 10;
    private int n;
    private double[] x = new double[capacity];
    private double sumx = 0.0;

    private void increaseCapacity() {
        capacity *= 2;
        double[] temp = new double[capacity];
        for (int i = 0; i < capacity; i++) {
            temp[i] = x[i];
        }
        x = temp;
    }

    public void add(double value) {
        if (n == capacity) increaseCapacity();
        x[n++] = value;
        sumx += value;
    }

    public double mean() {
        return sumx / n;
    }

    public double variance() {
        double xbar = mean();
        double xxbar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
        }
        return xxbar / (n - 1);
    }

    public double stddev() {
        return Math.sqrt(variance());
    }

    public static void main(String[] args) {
        TwoPass dataset = new TwoPass();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            dataset.add(x);
        }
        double mean = dataset.mean();
        double stddev = dataset.stddev();
        double lo = mean - 1.96 * stddev;
        double hi = mean + 1.96 * stddev;

        // print results
        StdOut.println("mean             = " + mean);
        StdOut.println("sample stddev    = " + stddev);
        StdOut.print("95% approximate confidence interval = ");
        StdOut.println("[ " + lo + ", " + hi + " ]");
    }
}
