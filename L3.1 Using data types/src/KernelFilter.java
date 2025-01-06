import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies the identity filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);
        double rNew = 0.0;
        double gNew = 0.0;
        double bNew = 0.0;
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        Color color = picture.get((w + col + i) % w, (h + row + j) % h);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        rNew += r * weights[i + 1][j + 1];
                        gNew += g * weights[i + 1][j + 1];
                        bNew += b * weights[i + 1][j + 1];
                    }
                }
                int rR = (int) Math.round(rNew);
                int gG = (int) Math.round(gNew);
                int bB = (int) Math.round(bNew);
                if (rR > 255) rR = 255;
                if (gG > 255) gG = 255;
                if (bB > 255) bB = 255;
                if (rR < 0) rR = 0;
                if (gG < 0) gG = 0;
                if (bB < 0) bB = 0;
                Color newColor = new Color(rR, gG, bB);
                target.set(col, row, newColor);
                rNew = 0.0;
                gNew = 0.0;
                bNew = 0.0;
            }
        }
        return target;
    }

    public static Picture identity(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] filter = new double[3][3];
        filter[0][0] = 1.0 / 16.0;
        filter[1][0] = 2.0 / 16.0;
        filter[2][0] = 1.0 / 16.0;
        filter[0][1] = 2.0 / 16.0;
        filter[1][1] = 4.0 / 16.0;
        filter[2][1] = 2.0 / 16.0;
        filter[0][2] = 1.0 / 16.0;
        filter[1][2] = 2.0 / 16.0;
        filter[2][2] = 1.0 / 16.0;
        return kernel(picture, filter);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] filter = new double[3][3];
        filter[0][0] = 0;
        filter[1][0] = -1;
        filter[2][0] = 0;
        filter[0][1] = -1;
        filter[1][1] = 5;
        filter[2][1] = -1;
        filter[0][2] = 0;
        filter[1][2] = -1;
        filter[2][2] = 0;
        return kernel(picture, filter);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] filter = new double[3][3];
        filter[0][0] = -1;
        filter[1][0] = -1;
        filter[2][0] = -1;
        filter[0][1] = -1;
        filter[1][1] = 8;
        filter[2][1] = -1;
        filter[0][2] = -1;
        filter[1][2] = -1;
        filter[2][2] = -1;
        return kernel(picture, filter);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] filter = new double[3][3];
        filter[0][0] = -2;
        filter[1][0] = -1;
        filter[2][0] = 0;
        filter[0][1] = -1;
        filter[1][1] = 1;
        filter[2][1] = 1;
        filter[0][2] = 0;
        filter[1][2] = 1;
        filter[2][2] = 2;
        return kernel(picture, filter);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++) {
            weights[i][i] = 1.0 / 9.0;
        }
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);
        double rNew = 0.0;
        double gNew = 0.0;
        double bNew = 0.0;
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                for (int i = -4; i < 5; i++) {
                    for (int j = -4; j < 5; j++) {
                        Color color = picture.get((w + col + i) % w, (h + row + j) % h);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        rNew += r * weights[i + 4][j + 4];
                        gNew += g * weights[i + 4][j + 4];
                        bNew += b * weights[i + 4][j + 4];
                    }
                }
                int rR = (int) Math.round(rNew);
                int gG = (int) Math.round(gNew);
                int bB = (int) Math.round(bNew);
                if (rR > 255) rR = 255;
                if (gG > 255) gG = 255;
                if (bB > 255) bB = 255;
                if (rR < 0) rR = 0;
                if (gG < 0) gG = 0;
                if (bB < 0) bB = 0;
                Color newColor = new Color(rR, gG, bB);
                target.set(col, row, newColor);
                rNew = 0.0;
                gNew = 0.0;
                bNew = 0.0;
            }
        }
        return target;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);

        Picture identity = identity(picture);
        identity.show();

        Picture gaussian = gaussian(picture);
        gaussian.show();

        Picture sharpen = sharpen(picture);
        sharpen.show();

        Picture laplacian = laplacian(picture);
        laplacian.show();

        Picture emboss = emboss(picture);
        emboss.show();

        Picture motionBlur = motionBlur(picture);
        motionBlur.show();
    }
}
