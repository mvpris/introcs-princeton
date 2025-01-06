public class app2316 {
    public static void draw(int n, double size, double x, double y) {
        if (n == 0) return;
        double halfSize = size / 2;

        StdDraw.line(x, y - size, x, y + size);
        StdDraw.line(x - size, y, x + size, y);

        draw(n - 1, halfSize, x - halfSize, y + halfSize); // Upper left
        draw(n - 1, halfSize, x - halfSize, y - halfSize); // Bottom left
        draw(n - 1, halfSize, x + halfSize, y - halfSize); // Bottom right
        draw(n - 1, halfSize, x + halfSize, y + halfSize); // Upper right
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}

