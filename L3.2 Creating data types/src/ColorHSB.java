public class ColorHSB {
    private static final int ANGLE = 360;
    private final int h, s, b;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h >= ANGLE) throw new IllegalArgumentException("Hue is out of range");
        if (s < 0 || s > 100) throw new IllegalArgumentException("Saturation is out of range");
        if (b < 0 || b > 100) throw new IllegalArgumentException("Brightness is out of range");
        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return s == 0 || b == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException("Color is null");
        return Math.min((h - that.h) * (h - that.h), (ANGLE - Math.abs(h - that.h)) * (ANGLE - Math.abs(h - that.h))) +
                (s - that.s) * (s - that.s) + (b - that.b) * (b - that.b);
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB colorHSB1 = new ColorHSB(h, s, b);
        ColorHSB result = colorHSB1;
        int min = ANGLE * ANGLE * ANGLE;
        String name = "";
        while (!StdIn.isEmpty()) {
            String color = StdIn.readString();
            int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
            int b2 = StdIn.readInt();
            ColorHSB colorHSB2 = new ColorHSB(h2, s2, b2);
            int dist = colorHSB1.distanceSquaredTo(colorHSB2);
            if (dist < min) {
                min = dist;
                name = color;
                result = colorHSB2;
            }
        }
        StdOut.println(name + " " + result);
    }
}
