public class app1518 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    StdDraw.filledSquare(0.5 + 2 * j, 0.5 + i, 0.5);
                } else StdDraw.filledSquare(1.5 + 2 * j, 0.5 + i, 0.5);
            }
        }
        StdDraw.show();
    }
}
