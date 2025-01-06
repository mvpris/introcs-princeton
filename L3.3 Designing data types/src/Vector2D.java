public class Vector2D {
    private final double x;
    private final double y;

    public Vector2D(double x, double y) { // Make a defensive copy to ensure immutability.
        this.x = x;
        this.y = y;
    }

    public Vector2D plus(Vector2D that) { // Sum of this vector and that.
        return new Vector2D(this.x + that.x, this.y + that.y);
    }

    public Vector2D minus(Vector2D that) {
        return new Vector2D(x - that.x, y - that.y);
    }

    public Vector2D scale(double alpha) { // Scale this vector by alpha.
        return new Vector2D(alpha * x, alpha * y);
    }

    public double dot(Vector2D that) { // Dot product of this vector and that.
        return x * that.x + y * that.y;
    }

    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    public Vector2D direction() {
        return this.scale(1 / this.magnitude());
    }

    public double cartesian(int i) {
        double[] coords = new double[2];
        coords[0] = x;
        coords[1] = y;
        return coords[i];
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(1, 2);
        Vector2D v2 = new Vector2D(3, 4);
        System.out.println("v1=" + v1);
        System.out.println("v2=" + v2);
        Vector2D plus = v1.plus(v2);
        Vector2D minus = v1.minus(v2);
        double dot = v1.dot(v2);
        double magnitude = v1.magnitude();
        Vector2D scale = v1.scale(3.0);
        Vector2D direction = v1.direction();
        double[] coordsv1 = new double[2];
        for (int i = 0; i < coordsv1.length; i++) {
            coordsv1[i] = v1.cartesian(i);
        }
        System.out.println("v1+v2=" + plus);
        System.out.println("v1-v2=" + minus);
        System.out.println("v1*v2=" + dot);
        System.out.println("|v1|=" + magnitude);
        System.out.println("3.0*v1=" + scale);
        System.out.println("unit v1=" + direction);
        StdArrayIO.print(coordsv1);
    }
}
