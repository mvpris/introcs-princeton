public class app1531 {
    public static void main(String[] args) {
        double R = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);
        double a = Double.parseDouble(args[2]);

        int canvasWidth = 500;
        int canvasHeight = 500;
        double scale = 2 * R + r + a;
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(-scale, scale);
        StdDraw.setYscale(-scale, scale);
        double n = 10000.0;
        for (int i = 0; i < n; i++) {
            double t = 2 * Math.PI * i / n;
            double x = (R + r) * Math.cos(t) - (r + a) * Math.cos((R + r) * (t) / r);
            double y = (R + r) * Math.sin(t) - (r + a) * Math.sin((R + r) * (t) / r);
            StdDraw.point(x, y);
        }
        StdDraw.show();
    }
}
