import java.awt.*;

public class Grayscale314 {
    public static void main(String[] args) { // Show image in grayscale.
        Picture picture = new Picture(args[0]);
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                Color color = picture.get(col, row);
                Color gray = Luminance313.toGray(color);
                picture.set(col, row, gray);
            }
        }
        picture.show();
        picture.save(args[1] + "Grayscale.jpg");
    }
}
