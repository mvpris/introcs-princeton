import java.awt.*;

public class app3140 {
    public static Color blend(Color c1, Color c2, double alpha) { // Compute blend of colors c1 and c2, weighted by alpha.
        double r = (1 - alpha) * c1.getRed() + alpha * c2.getRed();
        double g = (1 - alpha) * c1.getGreen() + alpha * c2.getGreen();
        double b = (1 - alpha) * c1.getBlue() + alpha * c2.getBlue();
        return new Color((int) r, (int) g, (int) b);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        In in = new In();
        Picture[] pics = new Picture[n];
        for (int i = 0; i < n; i++) {
            pics[i] = new Picture(in.readString());
        }

        int width = pics[0].width();
        int height = pics[0].height();

        Picture black = new Picture(width, height);
        for (int col = 0; col < black.width(); col++) {
            for (int row = 0; row < black.height(); row++) {
                black.set(col, row, Color.BLACK);
            }
        }

        int m = 1000;
        Picture picture = new Picture(width, height);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int col = 0; col < width; col++) {
                    for (int row = 0; row < height; row++) {
                        Color c1 = pics[i].get(col, row);
                        double alpha = (double) j / m;
                        Color color = blend(c1, Color.BLACK, alpha);
                        picture.set(col, row, color);
                    }
                }
                picture.show();
            }
            if (i != n - 1) {
                for (int j = 0; j < m; j++) {
                    for (int col = 0; col < width; col++) {
                        for (int row = 0; row < height; row++) {
                            Color c1 = pics[i + 1].get(col, row);
                            double alpha = (double) j / m;
                            Color color = blend(Color.BLACK, c1, alpha);
                            picture.set(col, row, color);
                        }
                    }
                    picture.show();
                }
            }
        }
    }
}

