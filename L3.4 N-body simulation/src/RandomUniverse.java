public class RandomUniverse {
    private final int n;
    private final RandomBody[] bodies;

    public RandomUniverse(int n) {
        double radius = 1e11;
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);

        this.n = n;
        bodies = new RandomBody[n];
        for (int i = 0; i < n; i++) {
            bodies[i] = new RandomBody();
        }
    }

    public void increaseTime(double dt) {
        Vector[] f = new Vector[n];
        for (int i = 0; i < n; i++)
            f[i] = new Vector(new double[2]);
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
        RandomUniverse newton = new RandomUniverse(Integer.parseInt(args[0]));
        double dt = 50000;
        StdDraw.enableDoubleBuffering();
        while (true) {
            StdDraw.clear();
            newton.increaseTime(dt);
            newton.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
//        java RandomUniverse 10
    }
}
