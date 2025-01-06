import java.awt.*;

public class app3141 {
    public static void main(String[] args) {
        String filename = args[0];
        double s = Double.parseDouble(args[1]);
        double x = Double.parseDouble(args[2]);
        double y = Double.parseDouble(args[3]);

        Picture source = new Picture(filename);
        int w = source.width();
        int h = source.height();
        Picture target = new Picture(w, h);

        for (int colT = 0; colT < w; colT++) {
            for (int rowT = 0; rowT < h; rowT++) {
                int colS = (int) (x * w - w / (2 * s) + colT / s);
                int rowS = (int) (y * h - h / (2 * s) + rowT / s);
                if (colS < 0 || colS >= w || rowS < 0 || rowS >= h)
                    target.set(colT, rowT, Color.BLACK);
                else
                    target.set(colT, rowT, source.get(colS, rowS));
            }
        }
        target.show();
    }
}
