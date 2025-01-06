public class app2227 {
    private static void drawBarGraph(double[] values) {
        StdDraw.clear();

        for (int i = 0; i < values.length; i++) {
            double x = i + 0.5; // Center the bar on the x-axis
            double y = values[i] / 2.0; // Scale the height of the bar

            StdDraw.filledRectangle(x, y, 0.4, y);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java AnimatedBarGraph <m>");
            System.exit(1);
        }

        int m = Integer.parseInt(args[0]);
        double[] values = new double[m];

        // Set up StdDraw
        StdDraw.setXscale(0, m);
        StdDraw.setYscale(0, 1.0);
        StdDraw.enableDoubleBuffering();

        while (true) {
            // Read a new double value from standard input
            double newValue = Math.random(); // Replace this with your own method of reading a double

            // Shift the values to the left and add the new value at the end
            for (int i = 0; i < m - 1; i++) {
                values[i] = values[i + 1];
            }
            values[m - 1] = newValue;

            // Draw the bar graph
            drawBarGraph(values);

            // Show and pause briefly for animation effect
            StdDraw.show();
            StdDraw.pause(100); // Adjust the pause duration as needed
        }
    }
}
