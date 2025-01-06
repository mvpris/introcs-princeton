import java.awt.*;

public class app316 {
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        int w = source.width();
        int h = source.height();
        Picture pictureR = new Picture(w, h);
        Picture pictureG = new Picture(w, h);
        Picture pictureB = new Picture(w, h);

        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                Color pixel = source.get(col, row);
                int R = pixel.getRed();
                int G = pixel.getGreen();
                int B = pixel.getBlue();
                Color redColor = new Color(R, 0, 0);
                Color greenColor = new Color(0, G, 0);
                Color blueColor = new Color(0, 0, B);
                pictureR.set(col, row, redColor);
                pictureG.set(col, row, greenColor);
                pictureB.set(col, row, blueColor);
            }
        }
        pictureR.show();
        pictureG.show();
        pictureB.show();
    }
}
