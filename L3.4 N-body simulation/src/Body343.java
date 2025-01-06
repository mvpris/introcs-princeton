public class Body343 {
    private Vector r;
    private Vector v;
    private final double mass;

    public Body343(Vector r0, Vector v0, double m0) {
        r = r0;
        v = v0;
        mass = m0;
    }

    public void move(Vector force, double dt) { // Update position and velocity.
        Vector a = force.scale(1 / mass);
        v = v.plus(a.scale(dt));
        r = r.plus(v.scale(dt));
    }

    public Vector forceFrom(Body343 b) { // Compute force on this body from b.
        Body343 a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double magnitude = (G * a.mass * b.mass) / (dist * dist);
        Vector force = delta.direction().scale(magnitude);
        return force;
    }

    public void draw() {
        double massScaleFactor = 1e-4; // Adjust this value to get a suitable size for the circle
        StdDraw.setPenRadius(massScaleFactor * mass);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    }

    public static void main(String[] args) {
        Vector r1 = new Vector(new double[]{0.0, 0.77});
        Vector v1 = new Vector(new double[]{0.015, -0.044});
        double m1 = 1500;
        Vector r2 = new Vector(new double[]{-0.53, 0.77});
        Vector v2 = new Vector(new double[]{0.015, -0.044});
        double m2 = 250;
        Body343 body1 = new Body343(r1, v1, m1);
        Body343 body2 = new Body343(r2, v2, m2);
        Vector gravity = new Vector(new double[]{0.0, -0.0981});
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
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
