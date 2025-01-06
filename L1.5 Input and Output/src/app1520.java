public class app1520 {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-1.5, 1.5);
        StdDraw.setYscale(-1.5, 1.5);
        StdDraw.setPenColor(StdDraw.RED);
//        Heart
        double[] xs = {-1, 0, 1, 0};
        double[] ys = {0, 1, 0, -1};
        StdDraw.filledPolygon(xs, ys);

        StdDraw.filledCircle(-0.5, 0.5, 1 / Math.sqrt(2));
        StdDraw.filledCircle(0.5, 0.5, 1 / Math.sqrt(2));

        StdDraw.show();
        StdDraw.pause(1500);
        StdDraw.clear();
        StdDraw.show();

//        Spade

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(0, -1, 0.5, 0.25);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(0.5, -0.7, 0.5);
        StdDraw.filledCircle(-0.5, -0.7, 0.5);
        StdDraw.setPenColor(StdDraw.BLACK);
        double[] xs2 = {-1, 0, 1, 0};
        double[] ys2 = {0.25, 1.25, 0.25, -0.75};
        StdDraw.filledPolygon(xs2, ys2);
        StdDraw.filledCircle(-0.5, -0.25, 1 / Math.sqrt(2));
        StdDraw.filledCircle(0.5, -0.25, 1 / Math.sqrt(2));
        StdDraw.show();
        StdDraw.pause(1500);
        StdDraw.clear();
        StdDraw.show();

//        Diamond
        StdDraw.setPenColor(StdDraw.RED);
        double[] xs3 = {-1, 0, 1, 0};
        double[] ys3 = {0, 1.25, 0, -1.25};
        StdDraw.filledPolygon(xs3, ys3);
        StdDraw.show();
        StdDraw.pause(1500);
        StdDraw.clear();
        StdDraw.show();

//        Spades
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(0, -0.90, 0.5, 0.25);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(0.5, -0.60, 0.5);
        StdDraw.filledCircle(-0.5, -0.60, 0.5);
        double sin = Math.sqrt(3) / 2;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(0, 0.5, 0.6);
        StdDraw.filledCircle(0.5, 0.5 - sin, 0.6);
        StdDraw.filledCircle(-0.5, 0.5 - sin, 0.6);

        StdDraw.show();
    }
}
