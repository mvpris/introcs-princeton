public class VectorComplex {
    private final Complex c;

    public VectorComplex(double re, double im) { // Make a defensive copy to ensure immutability.
        this.c = new Complex(re, im);
    }

    public VectorComplex plus(VectorComplex that) { // Sum of this vector and that.
        return new VectorComplex(this.c.re() + that.c.re(), this.c.im() + that.c.im());
    }

    public VectorComplex minus(VectorComplex that) {
        return new VectorComplex(c.re() - that.c.re(), c.im() - that.c.im());
    }

    public VectorComplex scale(double alpha) { // Scale this vector by alpha.
        return new VectorComplex(alpha * c.re(), alpha * c.im());
    }

    public double dot(VectorComplex that) { // Dot product of this vector and that.
        return c.re() * that.c.re() + c.im() * that.c.im();
    }

    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    public VectorComplex direction() {
        return this.scale(1 / this.magnitude());
    }

    public double cartesian(int i) {
        double[] coords = new double[2];
        coords[0] = c.re();
        coords[1] = c.im();
        return coords[i];
    }

    public String toString() {
        return "(" + c.re() + "," + c.im() + ")";
    }

    public static void main(String[] args) {
        VectorComplex v1 = new VectorComplex(1, 2);
        VectorComplex v2 = new VectorComplex(3, 4);
        System.out.println("v1=" + v1);
        System.out.println("v2=" + v2);
        VectorComplex plus = v1.plus(v2);
        VectorComplex minus = v1.minus(v2);
        double dot = v1.dot(v2);
        double magnitude = v1.magnitude();
        VectorComplex scale = v1.scale(3.0);
        VectorComplex direction = v1.direction();
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
