public class app247vis {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        // Draw blocked sites in black.
        StdDraw.enableDoubleBuffering();
        boolean[][] isOpen = app247.random(n, p);
        StdDraw.setPenColor(StdDraw.BLACK);
        app247.show(isOpen, false);
        StdDraw.show();

        // Draw full sites in blue.
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        boolean[][] isFull = app247.flow(isOpen);
        app247.show(isFull, true);
    }
}
