public class app1619a {
    public static void main(String[] args) {
        int n = 100;
        double[] a = new double[n];
        double xsum2 = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Math.sqrt(i);
            xsum2 += a[i];
        }
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(0, 2 * xsum2);
        StdDraw.setYscale(0, 2 * xsum2);
        StdDraw.setPenColor(StdDraw.GRAY);

        double xsum = 0;
        for (int i = 0; i < n; i++) {
            if (i > 25) StdDraw.setPenColor(StdDraw.YELLOW);
            xsum += 2 * a[i];
            StdDraw.filledCircle(xsum, 0, a[i]);
        }
        StdDraw.show();
    }
}
