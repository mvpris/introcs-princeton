import java.util.Objects;

public class Charge {
    private final double rx, ry;
    private double q;

    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q = q0;
    }

    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx * dx + dy * dy);
    }

    public void increaseCharge(double q0) {
        q += q0;
    }

    public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Charge that = (Charge) x;
        return (this.rx == that.rx)
                && (this.ry == that.ry)
                && (this.q == that.q);
    }

    public int hashCode() {
        return Objects.hash(rx, ry, q);
    }

    public String toString() {
        return q + " at (" + rx + ", " + ry + ")";
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        Charge c1 = new Charge(0.51, 0.63, 21.3);
        Charge c2 = new Charge(0.13, 0.94, 81.9);
        Charge c3 = new Charge(0.51, 0.63, 21.3);
        Charge c4 = c1;
        StdOut.println(c1);
        StdOut.println(c2);
        double v1 = c1.potentialAt(x, y);
        double v2 = c2.potentialAt(x, y);
        StdOut.printf("Potential=%.2e\n", (v1 + v2));
        StdOut.println("c1==c2: " + c1.equals(c2)); // checks different charges with different values
        StdOut.println("c1==c3: " + c1.equals(c3)); // checks different charges with identical values
        StdOut.println("c1==c4: " + c1.equals(c4)); // checks identically declared charges (with identical values)
        StdOut.println("c1.hashCode()=" + c1.hashCode());
        StdOut.println("c2.hashCode()=" + c2.hashCode());
        StdOut.println("c3.hashCode()=" + c3.hashCode());
        StdOut.println("c4.hashCode()=" + c4.hashCode());
        boolean truth = c1.hashCode() == c3.hashCode();
        StdOut.println("c1.hashCode()==c3.hashCode()=" + truth);
    }
}
