public class Body {
    private Vector r;
    private Vector v;
    private final double mass;

    public Body(Vector r0, Vector v0, double m0) {
        r = r0;
        v = v0;
        mass = m0;
    }

    public void move(Vector force, double dt) { // Update position and velocity.
        Vector a = force.scale(1 / mass);
        v = v.plus(a.scale(dt));
        r = r.plus(v.scale(dt));
    }

    public Vector forceFrom(Body b) { // Compute force on this body from b.
        Body a = this;
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
        Vector r1 = new Vector(new double[]{0.0, 0.77});
        Vector v1 = new Vector(new double[]{0.015, -0.044});
        double m1 = 155;
        Vector r2 = new Vector(new double[]{-0.53, 0.77});
        Vector v2 = new Vector(new double[]{0.015, -0.044});
        double m2 = 255;
        Body body1 = new Body(r1, v1, m1);
        Body body2 = new Body(r2, v2, m2);
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
