public class app2129 {
    public static double evaluateFunction(double t, int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.cos(i * t);
        }
        return sum / n;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int samples = 500;

        double[] t = new double[samples];
        double[] y = new double[samples];

        for (int i = 0; i < samples; i++) {
            t[i] = -10 + i * 20.0 / (samples - 1);
            y[i] = evaluateFunction(t[i], n);
        }

        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-1, 1);
        StdDraw.line(-10, 0, 10, 0); // x-axis
        StdDraw.line(0, -1, 0, 1);   // y-axis

        for (int i = 1; i < samples; i++) {
            StdDraw.line(t[i - 1], y[i - 1], t[i], y[i]);
        }
        StdDraw.show();
    }
}
