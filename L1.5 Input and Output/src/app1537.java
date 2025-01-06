public class app1537 {
    public static void main(String[] args) {
//        Image 1
        int n = Integer.parseInt(args[0]);
        boolean checkerboard = Boolean.parseBoolean(args[1]);
        int r = Integer.parseInt(args[2]);
        int g = Integer.parseInt(args[3]);
        int b = Integer.parseInt(args[4]);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);
        StdDraw.clear(StdDraw.BLACK);


        StdDraw.setPenColor(StdDraw.WHITE);
        for (int p = 0; p < n; p++) {
            for (int k = 0; k < n; k++) {
                double[][] x = {
                        {0 + k, 0.5 + k, 1 + k, 0.5 + k},
                        {0 + k, 0.25 + k, 0.25 + k},
                        {1 + k, 0.75 + k, 0.75 + k},
                        {0 + k, 0.25 + k, 0.25 + k},
                        {1 + k, 0.75 + k, 0.75 + k}
                };
                double[][] y = {
                        {0.5 + p, 1 + p, 0.5 + p, 0 + p},
                        {0.75 + p, 1 + p, 0.75 + p},
                        {0.75 + p, 1 + p, 0.75 + p},
                        {0.25 + p, 0 + p, 0.25 + p},
                        {0.25 + p, 0 + p, 0.25 + p}
                };
                for (int i = 0; i < x.length; i++) {
                    if (i == 0) StdDraw.setPenColor(StdDraw.GRAY);
                    else StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledPolygon(x[i], y[i]);
                }
            }
        }

        if (checkerboard) {
            StdDraw.setPenColor(r, g, b);
            for (int p = 0; p < n; p++) {
                for (int k = 0; k < n; k++) {
                    if (p % 2 == 0 && k % 2 == 0) {
                        double[] xc = {0 + k, 0 + k, 1 + k, 1 + k};
                        double[] yc = {0 + p, 1 + p, 1 + p, 0 + p};
                        StdDraw.filledPolygon(xc, yc);
                    }
                    if (p % 2 == 1 && k % 2 == 1) {
                        double[] xc = {0 + k, 0 + k, 1 + k, 1 + k};
                        double[] yc = {0 + p, 1 + p, 1 + p, 0 + p};
                        StdDraw.filledPolygon(xc, yc);
                    }
                }
            }

        }
        StdDraw.show();
    }
}
