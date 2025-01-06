public class app2316gpt {
    public static void draw(int n, double size, double x, double y) {
        if (n == 0) return;

        double halfSize = size / 2;

        // Draw the vertical line
        StdDraw.line(x, y - size, x, y + size);

        // Draw the horizontal line
        StdDraw.line(x - size, y, x + size, y);

        // Recursively draw each quadrant
        draw(n - 1, halfSize, x - halfSize, y + halfSize); // Upper left
        draw(n - 1, halfSize, x - halfSize, y - halfSize); // Bottom left
        draw(n - 1, halfSize, x + halfSize, y - halfSize); // Bottom right
        draw(n - 1, halfSize, x + halfSize, y + halfSize); // Upper right
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java app2316 <depth>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        // Set up the canvas size
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setScale(0, 1);

        // Draw the paper cutting
        draw(n, 0.5, 0.5, 0.5);
    }
}
