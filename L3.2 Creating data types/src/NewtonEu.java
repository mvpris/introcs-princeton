import java.awt.*;

public class NewtonEu {
    static Color newton(Complex z) {
        double EPSILON = 1e-8;
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
        double xmin = -1;
        double ymin = -1;
        double width = 2;
        double heigth = 2;
        Picture pic = new Picture(n, n);

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                double x = xmin + col * width / n;
                double y = ymin + row * heigth / n;
                Complex z = new Complex(x, y);
                Color color = newton(z);
                pic.set(col, n - 1 - row, color);
            }
        }
        pic.show();
    }
}
