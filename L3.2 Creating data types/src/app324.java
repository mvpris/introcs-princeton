public class app324 {
    private final double x, y;
    private final double width;
    private final double height;

    public app324(double x1, double y1, double x2, double y2) {
        x = (x2 - x1) / 2;
        y = (y2 - y1) / 2;
        width = x2 - x1;
        height = y2 - y1;
    }

    public double area() {
        // Computes area
        return width * height;
    }

    public double perimeter() {
        // Computes perimeter
        return 2.0 * (width + height);
    }

    public boolean intersects(app324 b) {
        // Does this rectangle intersect b?
        return (Math.abs(x - b.x) <= (width + b.width) / 2) && (Math.abs(y - b.y) <= (height + b.height) / 2);
    }

    public boolean contains(app324 b) {
        // Is b inside this rectangle?
        return (Math.abs(x - b.x) <= (width - b.width) / 2) && (Math.abs(y - b.y) <= (height - b.height) / 2);
    }

    public void draw(app321 b) {
        // Draw rectangle on standard drawing.
        StdDraw.rectangle(x, y, width / 2, height / 2);
    }

    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        app321 rect = new app321(x1, y1, x2, y2);
        rect.draw(rect);
    }
}
