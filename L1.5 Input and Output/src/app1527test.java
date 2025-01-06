public class app1527test {
    public static void main(String[] args) {
        int width = 800; // Set the width of the window
        int height = 400; // Set the height of the window

        // Set the scale of the coordinate system
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, 2 * Math.PI); // X-axis from 0 to 2*pi
        StdDraw.setYscale(-1, 1); // Y-axis from -1 to 1

        // Plot the sine wave as individual points
        int numPoints = 1000; // Number of points to plot

        StdDraw.setPenColor(StdDraw.RED); // Set the pen color
        StdDraw.setPenRadius(0.01); // Set the pen radius

        for (int i = 0; i < numPoints; i++) {
            double x = i * 2 * Math.PI / (numPoints - 1);
            double y = Math.sin(x);
            StdDraw.point(x, y);
        }
    }
}
