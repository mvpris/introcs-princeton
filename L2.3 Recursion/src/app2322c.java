public class app2322c {
    public static void squares(int n, double x, double y, double size) {
        if (n == 0) return;

        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(x, y, size);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, size);
        StdDraw.show();
        StdDraw.pause(100);

        double halfSize = size / 2;
        double xul = x - size;
        double yul = y + size;
        double xur = x + size;
        double yur = y + size;
        double xlr = x + size;
        double ylr = y - size;
        double xll = x - size;
        double yll = y - size;

        squares(n - 1, xul, yul, halfSize);
        squares(n - 1, xur, yur, halfSize);
        squares(n - 1, xlr, ylr, halfSize);
        squares(n - 1, xll, yll, halfSize);
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        squares(n, 0.5, 0.5, 0.25);
    }
}
