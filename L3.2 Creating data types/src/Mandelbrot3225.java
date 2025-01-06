public class Mandelbrot3225 {
    private static int mand(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }

    public static int mand2(double x0, double y0, int max) {
        double re = x0 * x0 + y0 * y0 + x0;
        double im = x0 * y0 + y0 * x0 + y0;
        double abs = re * re + im * im;
        if (abs > 2.0) return 0;
        double re2, im2, abs2;
        re2 = re * re + im * im + re;
        im2 = re * im + im * re + im;
        for (int t = 1; t < max; t++) {
            abs2 = re2 * re2 + im2 * im2;
            if (abs2 > 2.0) return t;
            re2 = re2 * re2 + im2 * im2 + re2;
            im2 = re2 * im2 + im2 * re2 + im2;
        }
        return max;
    }

    public static void computation(double xc, double yc, double size) {
        int n = 512;
        int max = 255;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                double x0 = xc - size / 2 + size * i / n;
                double y0 = yc - size / 2 + size * j / n;
                int gray = max - mand2(x0, y0, max);
            }
    }

    public static void main(String[] args) {
        double xc = Double.parseDouble(args[0]);
        double yc = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);
    }
}
