public class RandomBody {
    private Vector r;
    private Vector v;
    private final double mass;

    public RandomBody() {
        double position = 5e10;
        double velocity = 1e4;
        double massMin = 1e28;
        double massMax = 1e29;

        r = new Vector(new double[]{
                StdRandom.uniformDouble(-position, position),
                StdRandom.uniformDouble(-position, position)});
        v = new Vector(new double[]{
                StdRandom.uniformDouble(-velocity, velocity),
                StdRandom.uniformDouble(-velocity, velocity)});
        mass = StdRandom.uniformDouble(massMin, massMax);
    }

    public void move(Vector force, double dt) { // Update position and velocity.
        Vector a = force.scale(1 / mass);
        v = v.plus(a.scale(dt));
        r = r.plus(v.scale(dt));
    }

    public Vector forceFrom(RandomBody b) { // Compute force on this body from b.
        RandomBody a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double magnitude = (G * a.mass * b.mass) / (dist * dist);
        Vector force = delta.direction().scale(magnitude);
        return force;
    }

    public void draw() {
        StdDraw.setPenRadius(0.0125);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    }

    public static void main(String[] args) {
        RandomBody body1 = new RandomBody();
        RandomBody body2 = new RandomBody();
        Vector gravity = new Vector(new double[]{0.0, -0.0981});
        StdDraw.setXscale(-1.0e11, 1.0e11);
        StdDraw.setYscale(-1.0e11, 1.0e11);
        StdDraw.enableDoubleBuffering();
        while (true) {
            StdDraw.clear();
            body1.move(gravity, 0.25);
            body2.move(body2.forceFrom(body1), 0.25);
            body1.draw();
            body2.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
