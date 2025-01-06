public class app241bVisualiser {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.enableDoubleBuffering();

        // Draw false elements in black.
        boolean[][] a = app241b.hadamardMatrix(n);
        StdDraw.setPenColor(StdDraw.BLACK);
        app241show.show(a, false);

        // Draw true elements in blue.
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        app241show.show(a, true);
        StdDraw.show();
    }
}
