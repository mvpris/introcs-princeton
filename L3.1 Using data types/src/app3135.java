public class app3135 {
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        int m = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);
        int width = source.width();
        int height = source.height();

        Picture target = new Picture(m * width, n * height);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int w = 0; w < width; w++) {
                    for (int h = 0; h < height; h++) {
                        target.set(i * width + w, j * height + h, source.get(w, h));
                    }
                }
            }
        }
        target.show();
    }
}
