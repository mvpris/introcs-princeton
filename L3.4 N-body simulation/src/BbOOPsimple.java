public class BbOOPsimple {
    private Vector r;
    private Vector v;
    private final double radius;

    public BbOOPsimple(Vector position, Vector velocity, double radius) {
        r = position;
        v = velocity;
        this.radius = radius;
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

    public static void main(String[] args) {
        double[] rc = {0.480, 0.860};
        double[] vc = {0.015, 0.023};
        Vector r = new Vector(rc);
        Vector v = new Vector(vc);
        double radius = 0.05;
        BbOOPsimple ball = new BbOOPsimple(r, v, radius);
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
