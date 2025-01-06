import java.awt.*;
import java.util.Scanner;

public class app318 {
    public static boolean isCompatible(Color pixel, Color color) {
        int threshold = 30; // You can adjust this value based on your needs

        int redDiff = Math.abs(pixel.getRed() - color.getRed());
        int greenDiff = Math.abs(pixel.getGreen() - color.getGreen());
        int blueDiff = Math.abs(pixel.getBlue() - color.getBlue());

        return redDiff < threshold && greenDiff < threshold && blueDiff < threshold;
    }
    
    public static void main(String[] args) {
        String filename = args[0];
        int x1 = Integer.parseInt(args[1]);
        int y1 = Integer.parseInt(args[2]);
        int x2 = Integer.parseInt(args[3]);
        int y2 = Integer.parseInt(args[4]);

        Picture picture = new Picture(filename);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int red = scanner.nextInt();
            int green = scanner.nextInt();
            int blue = scanner.nextInt();

            Color color = new Color(red, green, blue);
            boolean isCompatible = true;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    Color pixel = picture.get(x, y);
                    if (!isCompatible(pixel, color)) {
                        isCompatible = false;
                        break;
                    }
                }
                if (!isCompatible) break;
            }
            if (isCompatible) System.out.println(color);
        }
    }
}
