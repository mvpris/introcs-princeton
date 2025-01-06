import java.awt.*;

public class app1527 {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        int width = 800;
        int height = 400;
        StdDraw.setCanvasSize(width, height);
        double xscale = 50;
        double yscale = 2;
        StdDraw.setXscale(0, xscale);
        StdDraw.setYscale(-yscale, yscale);
        StdDraw.setPenColor(StdDraw.RED); // Set the pen color
        StdDraw.setPenRadius(0.005); // Set the pen radius

        Color[] col = {StdDraw.RED, StdDraw.GREEN, StdDraw.BLUE,
                StdDraw.BLACK, StdDraw.CYAN, StdDraw.DARK_GRAY,
                StdDraw.MAGENTA, StdDraw.LIGHT_GRAY, StdDraw.ORANGE};
        int c = 0;

        int SAMPLING_RATE = 44100;
        while (!StdIn.isEmpty()) {
            StdDraw.setPenColor(col[c]);
            c++;
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double hz = 440 * Math.pow(2, pitch / 12.0);
            int n = (int) (SAMPLING_RATE * duration);
            double[] a = new double[n + 1];
            for (int i = 0; i <= n; i++) {
                double x = 2 * Math.PI * i * hz / SAMPLING_RATE;
                a[i] = Math.sin(x);
                StdDraw.point(x, a[i]);
            }
            StdDraw.show();
            StdAudio.play(a);
        }
    }
}
