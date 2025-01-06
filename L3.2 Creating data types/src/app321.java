public class app321 {
    private final double x, y;      // center of rectangle
    private final double width;     // width of rectangle
    private final double height;    // height of rectangle

    public app321(double x0, double y0, double w, double h) {
        x = x0;
        y = y0;
        width = w;
        height = h;
    }

    public double area() {
        // Computes area
        return width * height;
    }

    public double perimeter() {
        // Computes perimeter
        return 2.0 * (width + height);
    }

    public boolean intersects(app321 b) {
        // Does this rectangle intersect b?
        return (Math.abs(x - b.x) <= (width + b.width) / 2) && (Math.abs(y - b.y) <= (height + b.height) / 2);
    }

    public boolean contains(app321 b) {
        // Is b inside this rectangle?
        return (Math.abs(x - b.x) <= (width - b.width) / 2) && (Math.abs(y - b.y) <= (height - b.height) / 2);
    }

    public void draw(app321 b) {
        // Draw rectangle on standard drawing.
        StdDraw.rectangle(x, y, width / 2, height / 2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        double area = 0.0;
        double perimeter = 0.0;
        double center = (min + max) / 2;
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        for (int i = 0; i < n; i++) {
            double width = StdRandom.uniformDouble(min, max);
            double height = StdRandom.uniformDouble(min, max);
            app321 rect = new app321(center, center, width, height);
            rect.draw(rect);
            area += rect.area();
            perimeter += rect.perimeter();
        }
        System.out.printf("Area=%.3f\n", area / n);
        System.out.printf("Perimeter=%.3f\n", perimeter / n);
    }
}
