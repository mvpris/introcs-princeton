public class app2322a {
    public static void squares(int n, double x, double y, double size) {
        if (n == 0) return;

        double halfSize = size / 2;
        
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(x, y, halfSize);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, halfSize);
        StdDraw.show();
        StdDraw.pause(100);

        double ratio = 2.2;
        double xul = x - halfSize;
        double yul = y + halfSize;
        double xur = x + halfSize;
        double yur = y + halfSize;
        double xlr = x + halfSize;
        double ylr = y - halfSize;
        double xll = x - halfSize;
        double yll = y - halfSize;

        squares(n - 1, xul, yul, size / ratio);
        squares(n - 1, xur, yur, size / ratio);
        squares(n - 1, xlr, ylr, size / ratio);
        squares(n - 1, xll, yll, size / ratio);
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        squares(n, 0.5, 0.5, 0.5);
    }
}
