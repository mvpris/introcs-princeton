import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class app3137gpt {
    public static void main(String[] args) throws Exception {
        File input = new File(args[0]);
        BufferedImage image = ImageIO.read(input);
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int ci = width / 2;
        int cj = height / 2;

        for (int si = 0; si < width; si++) {
            for (int sj = 0; sj < height; sj++) {
                double dx = si - ci;
                double dy = sj - cj;
                double distance = Math.sqrt(dx * dx + dy * dy);
                double theta = Math.PI / 256 * distance;

                int ti = (int) ((si - ci) * Math.cos(theta) - (sj - cj) * Math.sin(theta) + ci);
                int tj = (int) ((si - ci) * Math.sin(theta) + (sj - cj) * Math.cos(theta) + cj);

                if (ti >= 0 && ti < width && tj >= 0 && tj < height) {
                    Color color = new Color(image.getRGB(ti, tj));
                    result.setRGB(si, sj, color.getRGB());
                }
            }
        }

        File output = new File("swirled_" + input.getName());
        ImageIO.write(result, "jpg", output);
    }
}
