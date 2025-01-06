import java.util.Objects;

public class Vector implements Comparable<Vector> {
    private final double[] coords;

    public Vector(double[] a) { // Make a defensive copy to ensure immutability.
        coords = new double[a.length];
        for (int i = 0; i < a.length; i++)
            coords[i] = a[i];
    }

    public Vector plus(Vector that) { // Sum of this vector and that.
        if (this.coords.length != that.coords.length)
            throw new IllegalArgumentException("Dimensions disagree.");

        double[] result = new double[coords.length];
        for (int i = 0; i < coords.length; i++)
            result[i] = this.coords[i] + that.coords[i];
        return new Vector(result);
    }

    public Vector minus(Vector that) {
        if (this.coords.length != that.coords.length)
            throw new IllegalArgumentException("Dimensions disagree.");

        double[] result = new double[coords.length];
        for (int i = 0; i < coords.length; i++) {
            result[i] = this.coords[i] - that.coords[i];
        }
        return new Vector(result);
    }

    public Vector scale(double alpha) { // Scale this vector by alpha.
        double[] result = new double[coords.length];
        for (int i = 0; i < coords.length; i++)
            result[i] = alpha * coords[i];
        return new Vector(result);
    }

    public double dot(Vector that) { // Dot product of this vector and that.
        if (this.coords.length != that.coords.length)
            throw new IllegalArgumentException("Dimensions disagree.");

        double sum = 0.0;
        for (int i = 0; i < coords.length; i++)
            sum += this.coords[i] * that.coords[i];
        return sum;
    }

    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    public Vector direction() {
        return this.scale(1 / this.magnitude());
    }

    public double cartesian(int i) {
        return coords[i];
    }

    @Override
    public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Vector that = (Vector) x;
        boolean flag = true;
        for (int i = 0; i < coords.length; i++) {
            if (this.cartesian(i) != that.cartesian(i)) flag = false;
        }
        return (this.magnitude() == that.magnitude()) && flag;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(coords.length);
        for (int i = 0; i < coords.length; i++) {
            result = 31 * result + Objects.hash(coords[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        String vector = "(";
        for (int i = 0; i < coords.length - 1; i++) {
            vector += coords[i] + ", ";
        }
        vector += coords[coords.length - 1] + ")";
        return vector;
    }

    @Override
    public int compareTo(Vector that) {
        int minLength = Math.min(this.coords.length, that.coords.length);
        for (int i = 0; i < minLength; i++) {
            if (this.coords[i] < that.coords[i]) return -1;
            else if (this.coords[i] > that.coords[i]) return 1;
        }
        return Integer.compare(this.coords.length, that.coords.length);
    }

    public static void main(String[] args) {
        double[] coordsv1 = {1, 2, 3, 4, 5};
        double[] coordsv2 = {3, 4, 5, 6, 7};
        double[] coordsv3 = {1, 2, 3, 4, 5};
        Vector v1 = new Vector(coordsv1);
        Vector v2 = new Vector(coordsv2);
        Vector v3 = new Vector(coordsv3);
//        System.out.println("v1.equals(v2)=" + v1.equals(v2));
//        System.out.println("v1.equals(v3)=" + v1.equals(v3));
        System.out.println("v1.hashCode()=" + v1.hashCode());
        System.out.println("v2.hashCode()=" + v2.hashCode());
        System.out.println("v3.hashCode()=" + v3.hashCode());
//        System.out.println("v1=" + v1);
//        System.out.println("v2=" + v2);
//        Vector plus = v1.plus(v2);
//        Vector minus = v1.minus(v2);
//        double dot = v1.dot(v2);
//        double magnitude = v1.magnitude();
//        Vector scale = v1.scale(3.0);
//        Vector direction = v1.direction();
//        double[] coordsv11 = new double[coordsv1.length];
//        for (int i = 0; i < coordsv1.length; i++) {
//            coordsv11[i] = v1.cartesian(i);
//        }
//        System.out.println("v1+v2=" + plus);
//        System.out.println("v1-v2=" + minus);
//        System.out.println("v1*v2=" + dot);
//        System.out.println("|v1|=" + magnitude);
//        System.out.println("3.0*v1=" + scale);
//        System.out.println("unit v1=" + direction);
//        StdArrayIO.print(coordsv11);
    }
}
