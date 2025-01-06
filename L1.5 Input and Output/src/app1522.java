public class app1522 {
    public static void main(String[] args) {
        String s = args[0];
        int pause = Integer.parseInt(args[1]);
        double scale = 10.0;
        int width = 2;
        int height = 1;
        double n = 2 * scale - width - 1;
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-scale, scale);
        StdDraw.setYscale(-scale, scale);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < n; i++) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(-scale + width + i, 0, width, height);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(-scale + width + i, 0, s);
            StdDraw.show();
            StdDraw.pause(pause);
            StdDraw.clear();
        }
        for (int i = 0; i < n; i++) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(scale - width - i, 0, width, height);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(scale - width - i, 0, s);
            StdDraw.show();
            StdDraw.pause(pause);
            StdDraw.clear();
        }
    }
}
