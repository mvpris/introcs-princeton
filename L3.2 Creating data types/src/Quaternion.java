public class Quaternion {
    private final double a0;
    private final double a1;
    private final double a2;
    private final double a3;

    public Quaternion(double a0, double a1, double a2, double a3) {
        this.a0 = a0;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public double magnitude() {
        return Math.sqrt(a0 * a0 + a1 * a1 + a2 * a2 + a3 * a3);
    }

    public Quaternion conjugate() {
        return new Quaternion(-a0, -a1, -a2, -a3);
    }


    public Quaternion inverse() {
        double magnitude2 = magnitude() * magnitude();
        return new Quaternion(a0 / magnitude2, -a1 / magnitude2, a2 / magnitude2, -a3 / magnitude2);
    }

    public Quaternion sum(Quaternion b) {
        return new Quaternion(a0 + b.a0, a1 + b.a1, a2 + b.a2, a3 + b.a3);
    }

    public Quaternion product(Quaternion b) {
        return new Quaternion(
                a0 * b.a0 - a1 * b.a1 - a2 * b.a2 - a3 * b.a3,
                a0 * b.a1 - a2 * b.a0 + a2 * b.a3 - a3 * b.a2,
                a0 * b.a2 - a2 * b.a3 + a2 * b.a0 + a3 * b.a1,
                a0 * b.a3 + a1 * b.a2 - a2 * b.a1 + a3 * b.a0);
    }

    public Quaternion quotient(Quaternion b) {
        return this.product(b.inverse());
    }

    public String toString() {
        return "(" + a0 + "," + a1 + "," + a2 + "," + a3 + ")";
    }

    public static void main(String[] args) {
        double a0 = Double.parseDouble(args[0]);
        double a1 = Double.parseDouble(args[1]);
        double a2 = Double.parseDouble(args[2]);
        double a3 = Double.parseDouble(args[3]);
        Quaternion a = new Quaternion(a0, a1, a2, a3);
        Quaternion b = new Quaternion(a1, a3, a2, a0);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("Magnitude(a)=" + a.magnitude());
        System.out.println("Conjugate(a)=" + a.conjugate());
        System.out.println("Inverse(a)=" + a.inverse());
        System.out.println("Sum(a+b)=" + a.sum(b));
        System.out.println("Product(a*b)=" + a.product(b));
        System.out.println("Quotient(a/b)=" + a.quotient(b));
    }
}
