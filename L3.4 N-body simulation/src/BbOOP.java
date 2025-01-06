public class BbOOP {
    private Vector r;
    private Vector v;
    private final double radius = 0.05;

    public BbOOP() {
        r = new Vector(randomCoordsr());
        v = new Vector(randomCoordsv());
    }

    public void move() {
        if (Math.abs(r.cartesian(0) + v.cartesian(0)) + radius > 1.0) {
            Vector vTemp = new Vector(new double[]{-v.cartesian(0), v.cartesian(1)});
            v = vTemp;
        }
        if (Math.abs(r.cartesian(1) + v.cartesian(1)) + radius > 1.0) {
            Vector vTemp = new Vector(new double[]{v.cartesian(0), -v.cartesian(1)});
            v = vTemp;
        }
        r = r.plus(v);
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(r.cartesian(0) - v.cartesian(0), r.cartesian(1) - v.cartesian(1), radius);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(r.cartesian(0), r.cartesian(1), radius);
    }

    private static double[] randomCoordsr() {
        double[] coords = new double[2];
        for (int i = 0; i < 2; i++) {
            coords[i] = StdRandom.uniformDouble(-1.0, 1.0);
        }
        return coords;
    }

    private static double[] randomCoordsv() {
        double[] coords = new double[2];
        for (int i = 0; i < 2; i++) {
            coords[i] = StdRandom.uniformDouble(-0.05, 0.05);
        }
        return coords;
    }

    public static void main(String[] args) {
        BbOOP ball = new BbOOP();
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear(StdDraw.GRAY);
        while (true) {
            ball.move();
            ball.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
