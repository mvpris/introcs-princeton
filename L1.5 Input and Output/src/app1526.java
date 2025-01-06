public class app1526 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        double rmin = Double.parseDouble(args[2]);
        double rmax = Double.parseDouble(args[3]);

        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for (int i = 0; i < n; i++) {
            double r = Math.random();
            if (r < p) StdDraw.setPenColor(StdDraw.BLACK);
            else StdDraw.setPenColor(StdDraw.WHITE);
            double radius = rmin + (Math.random() * (rmax - rmin));
            double x = Math.random() * 1;
            double y = Math.random() * 1;
            StdDraw.filledCircle(x, y, radius);
        }
        StdDraw.show();
    }
}
