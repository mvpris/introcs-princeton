public class app1533 {
    public static void main(String[] args) {
        double Ax = Double.parseDouble(args[0]);
        double wx = Double.parseDouble(args[1]);
        double thetax = Double.parseDouble(args[2]);
        double Ay = Double.parseDouble(args[3]);
        double wy = Double.parseDouble(args[4]);
        double thetay = Double.parseDouble(args[5]);

//        double rr = 10.0;
//        double Ax = Math.random() * rr;
//        double wx = Math.random() * rr;
//        double thetax = Math.random() * rr;
//        double Ay = Math.random() * rr;
//        double wy = Math.random() * rr;
//        double thetay = Math.random() * rr;
//        StdOut.print(Ax + " " + wx + " " + thetax + " " + Ay + " " + wy + " " + thetay);
//        StdOut.println();

        int canvasWidth = 500;
        int canvasHeight = 500;
        double scale = 10;
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(-scale, scale);
        StdDraw.setYscale(-scale, scale);

        thetax = Math.toRadians(thetax);
        thetay = Math.toRadians(thetay);
        int n = 50000;
        for (int t = 0; t < n; t++) {
            double x = Ax * Math.sin(wx * t + thetax);
            double y = Ay * Math.sin(wy * t + thetay);
            StdDraw.point(x, y);
        }
        StdDraw.show();

    }
}
