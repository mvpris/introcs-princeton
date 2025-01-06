public class app2410vis {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        StdDraw.enableDoubleBuffering();

        // Draw blocked sites in black.
        boolean[][] isOpen = app2410.random(n, p);
        StdDraw.setPenColor(StdDraw.BLACK);
        app2410.show(isOpen, false);

        // Draw full sites in blue.
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        boolean[][] isFull = app2410.flow(isOpen);
        app2410.show(isFull, true);
        StdDraw.show();
    }
}
