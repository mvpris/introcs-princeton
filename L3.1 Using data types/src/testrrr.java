import java.awt.*;

public class testrrr {
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);

        Color pixelGrayscaleValue = picture.get(1, 1);
        int value = pixelGrayscaleValue.getRGB();
        int valueR = pixelGrayscaleValue.getRed();

        System.out.println(pixelGrayscaleValue);
        System.out.println(value);
        System.out.println(valueR);
    }
}
