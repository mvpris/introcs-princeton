public class Bbg {
    public static void main(String[] args) {
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear(StdDraw.GRAY);
        double rx = 0.180, ry = 0.860;
        double vx = 0.015, vy = 0.023;
        double radius = 0.05;
        while (true) {
            if (Math.abs(rx + vx) + radius > 1.0) vx = -vx;
            if (Math.abs(ry + vy) + radius > 1.0) vy = -vy;
            vy -= 0.005;
            rx += vx;
            ry += vy;
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledCircle(rx - vx, ry - vy, radius);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
