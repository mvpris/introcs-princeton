public class Universe3D {
    private final int n;
    private final Body[] bodies;

    public Universe3D(String filename) {
        In in = new In(filename);
        n = in.readInt();
        double radius = in.readDouble();
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);
        bodies = new Body[n];
        for (int i = 0; i < n; i++) {
            double rx = in.readDouble();
            double ry = in.readDouble();
            double rz = in.readDouble();
            double[] position = {rx, ry, rz};
            double vx = in.readDouble();
            double vy = in.readDouble();
            double vz = in.readDouble();
            double[] velocity = {vx, vy, vz};
            double mass = in.readDouble();
            Vector r = new Vector(position);
            Vector v = new Vector(velocity);
            bodies[i] = new Body(r, v, mass);
        }
    }

    public void increaseTime(double dt) {
        Vector[] f = new Vector[n];
        for (int i = 0; i < n; i++)
            f[i] = new Vector(new double[3]);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j)
                    f[i] = f[i].plus(bodies[i].forceFrom(bodies[j]));
        for (int i = 0; i < n; i++)
            bodies[i].move(f[i], dt);
    }

    public void draw() {
        for (int i = 0; i < n; i++)
            bodies[i].draw();
    }

    public static void main(String[] args) {
        Universe3D newton = new Universe3D(args[0]);
        double dt = Double.parseDouble(args[1]);
        StdDraw.enableDoubleBuffering();
        while (true) {
            StdDraw.clear();
            newton.increaseTime(dt);
            newton.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
//        java Universe3D solarsystem.txt 1000000
    }
}
