import java.awt.*;

public class app314 {
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        double[] grayscale = new double[256];
        for (int j = 0; j < picture.width(); j++) {
            for (int i = 0; i < picture.height(); i++) {
                Color pixelGrayscaleColor = picture.get(j, i);
                int pixelGrayscaleValue = pixelGrayscaleColor.getRed();
                grayscale[pixelGrayscaleValue]++;
            }
        }

//        StdStats.plotBars(grayscale);
        
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 255);
        StdDraw.setYscale(0, StdStats.max(grayscale));
        for (int i = 0; i < grayscale.length; i++) {
            StdDraw.filledRectangle(i, grayscale[i] / 2, 0.25, grayscale[i] / 2);
        }
        StdDraw.show();
    }
}
