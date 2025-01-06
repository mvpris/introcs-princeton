public class app153 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double sum1 = 0;
        double sum2 = 0;
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = StdIn.readDouble();
            sum1 += x[i];
        }
        double average = sum1 / n;
        for (int i = 0; i < n; i++) {
            sum2 += Math.pow(x[i] - average, 2);
        }
        double stdDev = Math.sqrt(sum2 / (n - 1));
        StdOut.println("average=" + average);
        StdOut.println("standard deviation=" + stdDev);
    }
}
