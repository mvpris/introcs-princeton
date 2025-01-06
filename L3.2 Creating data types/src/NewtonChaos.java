import java.awt.*;

public class NewtonChaos {

    // return number of Mandelbrot iterations to check z = x + iy
    static Color newton(Complex z) {
        double EPSILON = 0.00000001;
        Complex four = new Complex(4, 0);
        Complex one = new Complex(1, 0);

        Complex root1 = new Complex(1, 0);
        Complex root2 = new Complex(-1, 0);
        Complex root3 = new Complex(0, 1);
        Complex root4 = new Complex(0, -1);

        for (int i = 0; i < 100; i++) {
            Complex f = z.times(z).times(z).times(z).minus(one);
            Complex fp = four.times(z).times(z).times(z);
            z = z.minus(f.divides(fp));
            if (z.minus(root1).abs() <= EPSILON) return Color.WHITE;
            if (z.minus(root2).abs() <= EPSILON) return Color.RED;
            if (z.minus(root3).abs() <= EPSILON) return Color.GREEN;
            if (z.minus(root4).abs() <= EPSILON) return Color.BLUE;
        }
        return Color.BLACK;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double xmin = -1.0;
        double ymin = -1.0;
        double width = 2.0;
        double height = 2.0;

        Picture picture = new Picture(n, n);

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                double x = xmin + col * width / n;
                double y = ymin + row * height / n;
                Complex z = new Complex(x, y);
                Color color = newton(z);
                picture.set(col, n - 1 - row, color);
            }
        }
        picture.show();
    }

}
