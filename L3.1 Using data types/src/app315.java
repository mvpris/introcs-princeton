public class app315 {
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        int w = source.width();
        int h = source.height();
        Picture target = new Picture(w, h);
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                target.set(w - 1 - col, row, source.get(col, row));
            }
        }
        target.show();
    }
}
