public class Data {
    private final double[] dataPoints;

    public Data(int n) {
        if (n < 0) throw new IllegalArgumentException("Size of n must be greater than 0.");
        dataPoints = new double[n];
    }

    public void addDataPoint(int i, double x) {
        if (i < 0 || i > dataPoints.length) throw new IllegalArgumentException("Index i is out of bounds");
        dataPoints[i] = x;
    }

    public void plotPoints() {
        StdStats.plotPoints(dataPoints);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        int trials = Integer.parseInt(args[2]);
        Data data = new Data(n);
        for (int i = 0; i < n; i++) {
            double estimate = PercolationProbability.estimate(n, p, trials);
            data.addDataPoint(i, estimate);
        }
        data.plotPoints();
    }
}
