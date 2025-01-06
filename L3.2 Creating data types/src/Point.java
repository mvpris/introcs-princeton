public class Point {
    private final double x0;
    private final double y0;

    public Point(double x, double y) {
        x0 = x;
        y0 = y;
    }

    public double distanceTo(Point q) {
        return Math.sqrt(Math.pow(x0 - q.x0, 2) + Math.pow(y0 - q.y0, 2));
    }

    public String toString() {
        return "(" + x0 + "," + y0 + ")";
    }

    public static void main(String[] args) {

    }
}
