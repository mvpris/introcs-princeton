public class Potential3327 {
    public static void drawArrow(double x0, double y0, double x1, double y1) {
        StdDraw.line(x0, y0, x1, y1);

        // calculate angle of the arrow
        double angle = Math.atan2(y1 - y0, x1 - x0);

        // draw the arrowhead
        double arrowHeadLength = 0.01;
        double arrowHeadAngle = Math.PI / 6;
        StdDraw.line(x1, y1, x1 - arrowHeadLength * Math.cos(angle + arrowHeadAngle), y1 - arrowHeadLength * Math.sin(angle + arrowHeadAngle));
        StdDraw.line(x1, y1, x1 - arrowHeadLength * Math.cos(angle - arrowHeadAngle), y1 - arrowHeadLength * Math.sin(angle - arrowHeadAngle));
    }

    public static void main(String[] args) {
        // IS NOT WORKING< FAULTY IMPLEMENTATION ALL AROUND>>>>>>>>>>>>>>>>>>
        // set up the canvas and the coordinate system
        int SIZE = 800;
        StdDraw.setCanvasSize(SIZE, SIZE);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        // read in n point charges
        int n = StdIn.readInt();
        Charge3327[] a = new Charge3327[n];
        for (int k = 0; k < n; k++) {
            double x0 = StdIn.readDouble();
            double y0 = StdIn.readDouble();
            double q0 = StdIn.readDouble();
            a[k] = new Charge3327(x0, y0, q0);
        }

        // compute the electric field at each point and draw the unit vector
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                double x = 1.0 * i / SIZE;
                double y = 1.0 * j / SIZE;
                Vector E = new Vector(new double[]{0, 0});
                for (int k = 0; k < n; k++) {
                    E = E.plus(a[k].fieldAt(x, y));
                }
                Vector unitE = E.direction();

                // draw the unit vector in the direction of E
                double scale = 0.02;  // adjust this value to change the length of the arrows
                double dx = scale * unitE.cartesian(0);
                double dy = scale * unitE.cartesian(1);
                drawArrow(x, y, x + dx, y + dy);
            }
        }
    }
}
