import java.awt.*;

public class ColorMandelbrot {
    public static void writeRGBFile(Out out, int n) {
        int R, G, B;
        for (int i = 0; i < n; i++) {
            R = StdRandom.uniformInt(n);
            G = StdRandom.uniformInt(n);
            B = StdRandom.uniformInt(n);
            out.println(R + " " + G + " " + B);
        }
    }

    public static Color[] readRGBFile(In in, int n) {
        Color[] a = new Color[n];
        for (int i = 0; i < n; i++) {
            int R = in.readInt();
            int G = in.readInt();
            int B = in.readInt();
            a[i] = new Color(R, G, B);
        }
        return a;
    }

    public static int mand(Complex z0, int d) {
        Complex z = z0;
        for (int t = 0; t < d; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return d;
    }

    public static void main(String[] args) {
        String filename = args[0];
        double xc = Double.parseDouble(args[1]);
        double yc = Double.parseDouble(args[2]);
        double size = Double.parseDouble(args[3]);
        Out out = new Out(filename);
        In in = new In(filename);

        int nColors = 256;
        int nPix = 512;

        writeRGBFile(out, nColors);
        Color[] colors = readRGBFile(in, nColors);

        Picture picture = new Picture(nPix, nPix);
        for (int col = 0; col < nPix; col++) {
            for (int row = 0; row < nPix; row++) {
                double x = xc - size / 2 + size * col / nPix;
                double y = yc - size / 2 + size * row / nPix;
                Complex z0 = new Complex(x, y);
                int t = mand(z0, nColors - 1);
                picture.set(col, nPix - 1 - row, colors[t]);
            }
        }
        picture.show();
//        java ColorMandelbrot mandelEu.txt -.5 0 2
//        java ColorMandelbrot mandelEu.txt -0.7615134027775 0.0794865972225 0.0032285925920
//        java ColorMandelbrot mandelEu.txt 0.10259 -0.641 0.0086
    }
}
