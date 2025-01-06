public class app3138 {
    public static Picture wave(Picture source, int amplitude, int frequency) {
        int w = source.width();
        int h = source.height();
        Picture target = new Picture(w, h);

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int xx = x;
                int yy = (int) (y + amplitude * Math.sin(2 * Math.PI * x / frequency));
                if (yy >= 0 && yy < h) {
                    target.set(x, y, source.get(xx, yy));
                }
            }
        }

        return target;
    }


    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        int amplitude = Integer.parseInt(args[1]);
        int frequency = Integer.parseInt(args[2]);
        Picture target = wave(source, amplitude, frequency);
        target.show();
    }
}
