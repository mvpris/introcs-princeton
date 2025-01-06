public class app244 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double incr = Double.parseDouble(args[1]);
        double p = 0.0;
        while (p < 1.0) {
            StdDraw.clear();
            StdDraw.enableDoubleBuffering();
            // Draw blocked sites in black.
            boolean[][] isOpen = Percolation.random(n, p);
            StdDraw.setPenColor(StdDraw.BLACK);
            PercolationVertical.show(isOpen, false);

            // Draw full sites in blue.
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            boolean[][] isFull = Percolation.flow(isOpen);
            PercolationVertical.show(isFull, true);
            p += incr;
            StdDraw.setPenColor(StdDraw.BOOK_RED);
            StdDraw.text(5, 5, "p=" + p);
            StdDraw.show();
            StdDraw.pause(1000);
        }
    }
}
