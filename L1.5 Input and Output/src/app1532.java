public class app1532 {
    public static void main(String[] args) {
        int s = 50;
        int m = 55;
        int h = 6;
        while (true) {
            int canvasWidth = 500;
            int canvasHeight = 500;
            double scale = 1.5;
            StdDraw.enableDoubleBuffering();
            StdDraw.setCanvasSize(canvasWidth, canvasHeight);
            StdDraw.setXscale(-scale, scale);
            StdDraw.setYscale(-scale, scale);

            double rc = 1;
            double rh = rc - 0.25;
            double rm = rc - 0.1;
            double rs = rc - 0.05;
            double rm2 = rc - 0.35;
            double rh2 = rc - 0.5;
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(0, 0, rc);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledCircle(0, 0, rc - 0.025);

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.01);
            int hours = 12;
            int min = 60;

            for (int i = 0; i < hours; i++) {
                double theta = 2 * Math.PI * i / hours;
                double x1 = rc * Math.cos(theta);
                double y1 = rc * Math.sin(theta);
                double x2 = rh * Math.cos(theta);
                double y2 = rh * Math.sin(theta);
                StdDraw.line(x1, y1, x2, y2);
            }

            StdDraw.setPenRadius(0.005);
            for (int i = 0; i < min; i++) {
                double theta = 2 * Math.PI * i / min;
                double x1 = rc * Math.cos(theta);
                double y1 = rc * Math.sin(theta);
                double x2 = rm * Math.cos(theta);
                double y2 = rm * Math.sin(theta);
                StdDraw.line(x1, y1, x2, y2);
            }


            StdDraw.setPenRadius(0.0035);
            StdDraw.setPenColor(StdDraw.RED);
            double thetas = -2 * Math.PI * s / min + 0.5 * Math.PI;
            double x1s = rs * Math.cos(thetas);
            double y1s = rs * Math.sin(thetas);
            StdDraw.line(x1s, y1s, 0, 0);

            StdDraw.setPenRadius(0.015);
            StdDraw.setPenColor(StdDraw.BLACK);
            double thetam = -2 * Math.PI * m / min + 0.5 * Math.PI;
            double x1m = rm2 * Math.cos(thetam);
            double y1m = rm2 * Math.sin(thetam);
            StdDraw.line(x1m, y1m, 0, 0);

            StdDraw.setPenRadius(0.015);
            StdDraw.setPenColor(StdDraw.BLACK);
            double thetah = -2 * Math.PI * h / hours + 0.5 * Math.PI;
            double x1h = rh2 * Math.cos(thetah);
            double y1h = rh2 * Math.sin(thetah);
            StdDraw.line(x1h, y1h, 0, 0);

            StdDraw.show();
            StdDraw.pause(1000);
            StdDraw.clear();

            s++;
            if (s == min) {
                s = 0;
                m++;
            }
            if (m == min) {
                m = 0;
                h++;
            }
            if (h == hours) {
                h = 0;
            }
        }
    }
}
