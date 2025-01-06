public class app2416vis {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        StdDraw.enableDoubleBuffering();

        // Draw blocked sites in black.
        boolean[][] isOpen = app2416.random(n, p);
        StdDraw.setPenColor(StdDraw.BLACK);
        app2416.show(isOpen, false);

        // Draw full sites in blue.
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        boolean[][] isFull = app2416.flow(isOpen);
        app2416.show(isFull, true);
        StdDraw.show();
    }
}
