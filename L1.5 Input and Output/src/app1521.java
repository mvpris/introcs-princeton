public class app1521 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);   // no of petals
        int ppp = 10000;    // points per petal
        int scale = 2;

        StdDraw.setXscale(-scale, scale);
        StdDraw.setYscale(-scale, scale);
//        StdDraw.setPenRadius(0.02);
        StdDraw.enableDoubleBuffering();

        if (n % 2 == 0) {
            for (int i = 0; i < ppp; i++) {
                double theta = 2 * Math.PI * i / ppp;
                double r = Math.sin(n * theta);
                double x = r * Math.cos(theta);
                double y = r * Math.sin(theta);
                StdDraw.point(x, y);
            }
        } else {
            for (int i = 0; i < ppp; i++) {
                double theta = 2 * Math.PI * i / ppp;
                double r = Math.sin(n * theta);
                double x = r * Math.cos(theta);
                double y = r * Math.sin(theta);
                StdDraw.point(x, y);
            }
        }
        StdDraw.show();
    }
}
