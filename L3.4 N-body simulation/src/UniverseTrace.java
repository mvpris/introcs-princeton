public class UniverseTrace {
    private final int n;
    private final Body[] bodies;

    public UniverseTrace(String filename) {
        In in = new In(filename);

        // number of bodies
        n = in.readInt();

        // the set scale for drawing on screen
        double radius = in.readDouble();
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);

        // read in the n bodies
        bodies = new Body[n];
        for (int i = 0; i < n; i++) {
            double rx = in.readDouble();
            double ry = in.readDouble();
            double[] position = {rx, ry};
            double vx = in.readDouble();
            double vy = in.readDouble();
            double[] velocity = {vx, vy};
            double mass = in.readDouble();
            Vector r = new Vector(position);
            Vector v = new Vector(velocity);
            bodies[i] = new Body(r, v, mass);
        }
    }

    // increment time by dt units, assume forces are constant in given interval
    public void increaseTime(double dt) {
        // initialize the forces to zero
        Vector[] f = new Vector[n];
        for (int i = 0; i < n; i++)
            f[i] = new Vector(new double[2]);

        // compute the forces
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j)
                    f[i] = f[i].plus(bodies[i].forceFrom(bodies[j]));

        // move the bodies
        for (int i = 0; i < n; i++)
            bodies[i].move(f[i], dt);
    }

    // draw the n bodies
    public void draw() {
        for (int i = 0; i < n; i++)
            bodies[i].draw();
    }

    // client to simulate a universe
    public static void main(String[] args) {
        UniverseTrace newton = new UniverseTrace(args[0]);
        double dt = Double.parseDouble(args[1]);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        while (true) {
            StdDraw.setPenColor(StdDraw.WHITE);
            newton.draw();
            newton.increaseTime(dt);
            StdDraw.setPenColor(StdDraw.BLACK);
            newton.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
//        java UniverseTrace 2body.txt 20000
    }
}
