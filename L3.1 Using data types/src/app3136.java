public class app3136 {
    public static Picture rotate(Picture source, double theta) {
        int width = source.width();
        int height = source.height();
        Picture target = new Picture(width, height);

        double sin = Math.sin(theta);
        double cos = Math.cos(theta);
        double x0 = 0.5 * (width - 1);     // point to rotate about
        double y0 = 0.5 * (height - 1);     // center of image

        for (int x = 0; x < source.width(); x++) {
            for (int y = 0; y < source.height(); y++) {
                double a = x - x0;
                double b = y - y0;
                int xx = (int) (a * cos - b * sin + x0);
                int yy = (int) (a * sin + b * cos + y0);

                // plot pixel (x, y) the same color as (xx, yy) if it's in bounds
                if (xx >= 0 && xx < width && yy >= 0 && yy < height) {
                    target.set(x, y, source.get(xx, yy));
                }
            }
        }
        return target;
    }

    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        double theta = Math.toRadians(Double.parseDouble(args[1]));
        Picture target = rotate(source, theta);
        target.show();
    }
}
