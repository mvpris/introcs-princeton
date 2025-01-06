public class app3137 {
    public static Picture swirl(Picture source) {
        int width = source.width();
        int height = source.height();
        Picture target = new Picture(width, height);

        double x0 = 0.5 * (width - 1);
        double y0 = 0.5 * (height - 1);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double dx = x - x0;
                double dy = y - y0;
                double distance = Math.sqrt(dx * dx + dy * dy);
                double theta = Math.PI / 256 * distance;

                int xx = (int) ((x - x0) * Math.cos(theta) - (y - y0) * Math.sin(theta) + x0);
                int yy = (int) ((x - x0) * Math.sin(theta) + (y - y0) * Math.cos(theta) + y0);

                if (xx >= 0 && xx < width && yy >= 0 && yy < height) {
                    target.set(x, yy, source.get(x, y));
                }
            }
        }

        return target;
    }

    public static void main(String[] args) throws Exception {
        Picture source = new Picture(args[0]);
        Picture target = swirl(source);
        target.show();
    }
}
