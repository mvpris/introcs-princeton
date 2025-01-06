import java.awt.*;

public class app312 {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException("r/g/b less than 0 or more than 255");
        }
        Color color = new Color(r, g, b);
        Picture picture = new Picture(256, 256);
        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                picture.set(i, j, color);
            }
        }
        picture.show();
    }
}
