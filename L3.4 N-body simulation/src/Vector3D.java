public class Vector3D {
    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) { // Make a defensive copy to ensure immutability.
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D plus(Vector3D that) { // Sum of this vector and that.
        return new Vector3D(this.x + that.x, this.y + that.y, this.z + that.z);
    }

    public Vector3D minus(Vector3D that) {
        return new Vector3D(x - that.x, y - that.y, z - that.z);
    }

    public Vector3D scale(double alpha) { // Scale this vector by alpha.
        return new Vector3D(alpha * x, alpha * y, alpha * z);
    }

    public double dot(Vector3D that) { // Dot product of this vector and that.
        return x * that.x + y * that.y + z * that.z;
    }

    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    public Vector3D direction() {
        return this.scale(1 / this.magnitude());
    }

    public double cartesian(int i) {
        double[] coords = new double[3];
        coords[0] = x;
        coords[1] = y;
        coords[2] = z;
        return coords[i];
    }

    public Vector3D crossProduct(Vector3D that) {
        return new Vector3D(y * that.z - z * that.y, z * that.x - x * that.z, x * that.y - y * that.x);
    }

    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }

    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(1, 2, 3);
        Vector3D v2 = new Vector3D(4, 5, 6);
        System.out.println("v1=" + v1);
        System.out.println("v2=" + v2);
        Vector3D plus = v1.plus(v2);
        Vector3D minus = v1.minus(v2);
        double dot = v1.dot(v2);
        double magnitude = v1.magnitude();
        Vector3D scale = v1.scale(3.0);
        Vector3D direction = v1.direction();
        double[] coordsv1 = new double[3];
        for (int i = 0; i < coordsv1.length; i++) {
            coordsv1[i] = v1.cartesian(i);
        }
        Vector3D crossProduct = v1.crossProduct(v2);
        System.out.println("v1+v2=" + plus);
        System.out.println("v1-v2=" + minus);
        System.out.println("v1*v2=" + dot);
        System.out.println("|v1|=" + magnitude);
        System.out.println("3.0*v1=" + scale);
        System.out.println("unit v1=" + direction);
        System.out.println("cross product |v1 X v2|=" + crossProduct);
        StdArrayIO.print(coordsv1);
    }
}
