public class Complex {
    private final double r;
    private final double theta;

    public Complex(double re, double im) {
        r = Math.sqrt(re * re + im * im);
        theta = Math.atan2(im, re);
    }

    public Complex plus(Complex b) { // Return the sum of this number and b.
        double real = re() + b.re();
        double imag = im() + b.im();
        return new Complex(real, imag);
    }

    public Complex times(Complex b) { // Return the product of this number and b.
        double radius = r * b.r;
        double angle = theta + b.theta;
        return new Complex(radius * Math.cos(angle), radius * Math.sin(angle));
    }

    public double abs() {
        return r;
    }

    public double re() {
        return r * Math.cos(theta);
    }

    public double im() {
        return r * Math.sin(theta);
    }

    public String toString() {
        return re() + " + " + im() + "i";
    }

    public static void main(String[] args) {
        Complex z0 = new Complex(1.0, 1.0);
        Complex z = z0;
        z = z.times(z).plus(z0);
        z = z.times(z).plus(z0);
        StdOut.println(z);
    }
}
