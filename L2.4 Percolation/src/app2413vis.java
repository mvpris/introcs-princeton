public class app2413vis {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        StdDraw.enableDoubleBuffering();

        // Draw blocked sites in black.
        boolean[][] isOpen = app2413.random(m, n, p);
        StdDraw.setPenColor(StdDraw.BLACK);
        app2413.show(isOpen, false);

        // Draw full sites in blue.
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        boolean[][] isFull = app2413.flow(isOpen);
        app2413.show(isFull, true);
        StdDraw.show();
    }
}
