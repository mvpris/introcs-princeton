public class app1519 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        int r = 2;
        double[] angle = new double[n];
        double[] x = new double[n];
        double[] y = new double[n];

        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);
        StdDraw.setPenRadius(0.01);
        StdDraw.enableDoubleBuffering();

        for (int i = 0; i < n; i++) {
            angle[i] = 2 * Math.PI * i / n;
            x[i] = 3 + r * Math.cos(angle[i]);
            y[i] = 3 + r * Math.sin(angle[i]);
            StdDraw.point(x[i], y[i]);
        }
        StdDraw.setPenRadius(0.002);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double random = Math.random();
                if (random < p) StdDraw.line(x[i], y[i], x[j], y[j]);
            }
        }

        StdDraw.show();
    }
}
