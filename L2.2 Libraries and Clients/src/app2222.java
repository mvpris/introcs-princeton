public class app2222 {
    public static void main(String[] args) {
// Plot trials iterations of IFS on StdIn.
        StdDraw.enableDoubleBuffering();
        int trials = Integer.parseInt(args[0]);
        double[] dist = StdArrayIO.readDouble1D();
        double[][] cx = StdArrayIO.readDouble2D();
        double[][] cy = StdArrayIO.readDouble2D();
        double[] point = {0.0, 0.0}; // Initial point

        for (int t = 0; t < trials; t++) {
            int r = StdRandom.discrete(dist);

            // Create a vector for the initial point
            double[] initialPoint = {point[0], point[1], 1.0};

            // Create a matrix for the transformation
            double[][] transformationMatrix = {
                    {cx[r][0], cx[r][1], cx[r][2]},
                    {cy[r][0], cy[r][1], cy[r][2]},
                    {0.0, 0.0, 1.0}
            };

            // Use matrix multiplication to transform the point
            double[] transformedPoint = Matrix.multiply(transformationMatrix, initialPoint);

            point[0] = transformedPoint[0] / transformedPoint[2];
            point[1] = transformedPoint[1] / transformedPoint[2];

            StdDraw.point(point[0], point[1]);
        }

        StdDraw.show();
    }
}
