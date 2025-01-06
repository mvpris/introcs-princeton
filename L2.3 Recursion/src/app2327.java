public class app2327 {
    public static void draw(double x1, double y1, double x2, double y2, double x3, double y3) {
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);
    }

    public static void triangle(int n, double x, double y, double s) {
        // X and y are base coordinates, s is size, n is number of recursions
        if (n == 0) return;

        //triangle coordinates
        double x1 = x;
        double y1 = y;
        double x2 = x1 + s;
        double y2 = y1;
        double x3 = (x1 + x2) / 2.0;
        double y3 = y1 + (Math.sqrt(3) * s / 2);

        draw(x1, y1, x2, y2, x3, y3);

        triangle(n - 1, x1, y1, s / 2);
        triangle(n - 1, (x1 + x2) / 2, (y1 + y2) / 2, s / 2);
        triangle(n - 1, (x1 + x3) / 2, (y1 + y3) / 2, s / 2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        triangle(n, 0, 0, 1);
    }
}
