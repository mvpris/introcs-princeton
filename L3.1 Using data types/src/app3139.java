public class app3139 {
    public static int random(int a, int b) {
        return a + StdRandom.uniformInt(b - a + 1);
    }

    public static Picture glass(Picture source) {
        int w = source.width();
        int h = source.height();
        Picture target = new Picture(w, h);

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int xx = (w + x + random(-5, 5)) % w;
                int yy = (h + y + random(-5, 5)) % h;
                target.set(x, y, source.get(xx, yy));
            }
        }

        return target;
    }


    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        Picture target = glass(source);
        target.show();
    }
}
