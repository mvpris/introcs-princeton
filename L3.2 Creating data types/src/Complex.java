public class Complex {
    private final double re;
    private final double im;

    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public Complex plus(Complex b) { // Return the sum of this number and b.
        double real = re + b.re;
        double imag = im + b.im;
        return new Complex(real, imag);
    }

    public Complex times(Complex b) { // Return the product of this number and b.
        double real = re * b.re - im * b.im;
        double imag = re * b.im + im * b.re;
        return new Complex(real, imag);
    }

    public Complex minus(Complex b) {
        double real = re - b.re;
        double imag = im - b.im;
        return new Complex(real, imag);
    }

    public Complex conjugate() {
        return new Complex(re, -im);
    }

    public Complex divides(Complex b) {
        double den = b.re * b.re + b.im * b.im;
        double real = (re * b.re + im * b.im) / den;
        double imag = (im * b.re - re * b.im) / den;
        return new Complex(real, imag);
    }

    public Complex power(int n) {
        return new Complex(Math.pow(abs(), n) * Math.cos(n * theta()), Math.pow(abs(), n) * Math.sin(n * theta()));
    }

    public double abs() {
        return Math.sqrt(re * re + im * im);
    }

    public double theta() {
        return Math.atan2(im, re);
    }

    public double re() {
        return re;
    }

    public double im() {
        return im;
    }

    public String toString() {
        String real = (re == (long) re) ? String.format("%d", (long) re) : String.format("%s", re);
        String imag = (im == (long) im) ? String.format("%d", (long) im) : String.format("%s", im);

        if (re == 0 && im == 0) return "0";
        if (re == 0 && im == 1) return "i";
        if (re == 0 && im == -1) return " - i";
        if (im == 1) return real + " + i";
        if (im == 0) return real + "";
        if (im == -1) return real + " - i";
        if (re == 0 && im < 0) return imag + "i";
        if (im < 0) return real + " " + imag + "i";
        return real + " + " + imag + "i";
    }

    public static void main(String[] args) {
//        Complex3216 z0 = new Complex3216(1.0, 1.0);
//        Complex3216 z = z0;
//        z = z.times(z).plus(z0);
//        z = z.times(z).plus(z0);
//        StdOut.println(z);
//        Complex3216 z1 = new Complex3216(3, -1);
//        Complex3216 z2 = new Complex3216(3, 0);
//        Complex3216 z3 = new Complex3216(0, 1);
//        Complex3216 z4 = new Complex3216(0, -2);
//        Complex3216 z5 = new Complex3216(1, 1);
//        Complex3216 z6 = new Complex3216(1, -1);
//        System.out.println(z1);
//        System.out.println(z2);
//        System.out.println(z3);
//        System.out.println(z4);
//        System.out.println(z5);
//        System.out.println(z6);
        Complex z1 = new Complex(2 * Math.cos(Math.PI / 3), 2 * Math.sin(Math.PI / 3));
        System.out.println(z1.power(5));
    }
}
