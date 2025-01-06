import java.awt.*;

public class app3129 {
    public static void write(Picture source, String filename) {
        Out out = new Out(filename + ".txt");
        int w = source.width();
        int h = source.height();

        out.println(w + " " + h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Color color = source.get(j, i);
                out.print(color.getRed() + " " + color.getGreen() + " " + color.getBlue() + " ");
            }
            out.println();
        }
    }

    public static void read(String filename) {
        In in = new In(filename + ".txt");
        int w = in.readInt();
        int h = in.readInt();
        Picture target = new Picture(w, h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int red = in.readInt();
                int green = in.readInt();
                int blue = in.readInt();
                Color color = new Color(red, green, blue);
                target.set(j, i, color);
            }
        }
        target.save(filename + ".jpg");
    }

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        String filename = args[1];
        write(picture, filename);
        read(filename);
    }
}
