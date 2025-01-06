public class app2414 {
    public static void curve(int n,
                             double x0, double y0,
                             double x1, double y1,
                             double gap, double err,
                             int trials) { // Perform experiments and plot results.
        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        double fxm = PercolationProbability.estimate(n, xm, trials);
        if (x1 - x0 < gap || Math.abs(ym - fxm) < err) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        curve(n, x0, y0, xm, fxm, gap, err, trials);
        StdDraw.filledCircle(xm, fxm, 0.005);
        curve(n, xm, fxm, x1, y1, gap, err, trials);
    }

    public static void main(String[] args) { // Plot experimental curve for n-by-n percolation system.
        int n = Integer.parseInt(args[0]);
        double gap = Double.parseDouble(args[1]);
        double err = Double.parseDouble(args[2]);
        int trials = Integer.parseInt(args[3]);
        curve(n, 0.0, 0.0, 1.0, 1.0, gap, err, trials);
    }
}
