public class app248 {
    static int maxDepth = 0;  // Maximum depth of recursion

    public static boolean[][] random(int n, double p) {
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = StdRandom.bernoulli(p);
        return a;
    }

    public static void show(boolean[][] a, boolean which) {
        int n = a.length;
        StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-1, n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == which)
                    StdDraw.filledSquare(j, n - i - 1, 0.5);
    }

    public static boolean[][] flow(boolean[][] isOpen) { // Fill every site reachable from the top row.
        int n = isOpen.length;
        boolean[][] isFull = new boolean[n][n];
        for (int j = 0; j < n; j++)
            flow(isOpen, isFull, 0, j, 0);
        return isFull;
    }

    public static void flow(boolean[][] isOpen, boolean[][] isFull, int i, int j, int depth) { // Fill every site reachable from (i, j).
        // Update maxDepth if the current depth is greater
        if (depth > maxDepth) maxDepth = depth;

        int n = isFull.length;
        if (i < 0 || i >= n) return;
        if (j < 0 || j >= n) return;
        if (!isOpen[i][j]) return;
        if (isFull[i][j]) return;
        isFull[i][j] = true;
        flow(isOpen, isFull, i + 1, j, depth + 1); // Down.
        flow(isOpen, isFull, i, j + 1, depth + 1); // Right.
        flow(isOpen, isFull, i, j - 1, depth + 1); // Left.
        flow(isOpen, isFull, i - 1, j, depth + 1); // Up.
    }

    public static boolean percolates(boolean[][] isOpen) {
        boolean[][] isFull = flow(isOpen);
        int n = isOpen.length;
        for (int j = 0; j < n; j++) {
            if (isFull[n - 1][j]) return true;
        }
        return false;
    }

    public static void estimate(int n, int trials, double[] pValues, int[][] maxDepths) {
        for (int i = 0; i < pValues.length; i++) {
            double p = pValues[i];
            for (int j = 0; j < trials; j++) {
                maxDepth = 0; // Reset maxDepth before each experiment
                boolean[][] isOpen = random(n, p); // Generate a new random grid
                flow(isOpen); // Calculate the flow
                maxDepths[i][j] = maxDepth; // Record the maximum recursion depth
            }
        }
    }

    public static double[] expectedValues(double[] pValues, int[][] maxDepths) {
        // Calculate the expected values
        double[] expectedValues = new double[pValues.length];
        for (int i = 0; i < pValues.length; i++) {
            expectedValues[i] = calculateAverage(maxDepths[i]); // Calculate the average maximum recursion depth for each p
        }
        return expectedValues;
    }

    public static double calculateAverage(int[] maxDepths) {
        // Calculate the average values in an array
        double average = 0.0;
        for (int i = 0; i < maxDepths.length; i++) {
            average += maxDepths[i];
        }
        return average / maxDepths.length;
    }

    public static void plot(double[] xValues, double[] yValues) {
        int n = xValues.length;

        // Set the scale of the canvas
        StdDraw.setXscale(0, 1); // assuming p values are between 0 and 1
        StdDraw.setYscale(0, StdStats.max(yValues) + StdStats.max(yValues) / 4); // assuming depths are positive

        // Draw the plot
        for (int i = 0; i < n - 1; i++) {
            StdDraw.line(xValues[i], yValues[i], xValues[i + 1], yValues[i + 1]);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
//        double p = Double.parseDouble(args[1]);
        int trials = Integer.parseInt(args[1]); // The number of trials to run for each value of p
        double[] pValues = {0.1, 0.15, 0.2, 0.25, 0.3, 0.35, 0.4, 0.45, 0.5, // The values of p to test
                0.55, 0.6, 0.65, 0.7, 0.75, 0.8, 0.85, 0.9, 0.95};
        int[][] maxDepths = new int[pValues.length][trials]; // Array to store the maximum recursion depths
        estimate(n, trials, pValues, maxDepths);
        double[] expectedValues = expectedValues(pValues, maxDepths); // Array with the averaged maximum recursion depths
        plot(pValues, expectedValues);
    }
}
