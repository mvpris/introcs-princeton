public class app1537gpt {

    // draw a diamond outline, center at (x, y), diagonals = 2*size
    public static void diamond(double x, double y, double size) {
        double[] px = {x + size, x, x - size, x};
        double[] py = {y, y + size, y, y - size};
        StdDraw.polygon(px, py);
    }

    // draw a filled diamond, center at (x, y), diagonals = 2*size
    public static void filledDiamond(double x, double y, double size) {
        double[] px = {x + size, x, x - size, x};
        double[] py = {y, y + size, y, y - size};
        StdDraw.filledPolygon(px, py);
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // for easy computation, set scale to match pattern
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // black diamond
                StdDraw.setPenRadius();
                StdDraw.setPenColor(StdDraw.BLACK);
                filledDiamond(i + 0.5, j + 0.5, 0.5);

                // red outline
                StdDraw.setPenRadius(0.005);
                StdDraw.setPenColor(StdDraw.RED);
                diamond(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}
