import java.awt.*;

public class ColorJulia {

    // return number of iterations to check z is in the Julia set of c
    static int julia(Complex c, Complex z, int maximumIterations) {
        for (int t = 0; t < maximumIterations; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(c);
        }
        return maximumIterations - 1;
    }

    public static void main(String[] args) {
        double real = Double.parseDouble(args[0]);      // a
        double imag = Double.parseDouble(args[1]);      // b
        Complex c = new Complex(real, imag);            // c = a + ib
        double xmin = -2.0;
        double ymin = -2.0;
        double width = 4.0;
        double height = 4.0;

        int n = 512;
        int ITERS = 256;

        // read in color map
        Color[] colors = new Color[ITERS];
        for (int t = 0; t < ITERS; t++) {
            int r = StdIn.readInt();
            int g = StdIn.readInt();
            int b = StdIn.readInt();
            colors[t] = new Color(r, g, b);
        }
        Picture picture = new Picture(n, n);

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                double x = xmin + col * width / n;
                double y = ymin + row * height / n;
                Complex z = new Complex(x, y);
                int t = julia(c, z, ITERS);
                picture.set(col, n - 1 - row, colors[t]);
            }
        }
        picture.show();
    }
}
