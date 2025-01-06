public class Complex3216 {
    private final double re;
    private final double im;

    public Complex3216(double real, double imag) {
        re = real;
        im = imag;
    }

    public Complex3216 plus(Complex3216 b) { // Return the sum of this number and b.
        double real = re + b.re;
        double imag = im + b.im;
        return new Complex3216(real, imag);
    }

    public Complex3216 times(Complex3216 b) { // Return the product of this number and b.
        double real = re * b.re - im * b.im;
        double imag = re * b.im + im * b.re;
        return new Complex3216(real, imag);
    }

    public double abs() {
        return Math.sqrt(re * re + im * im);
    }

    public double re() {
        return re;
    }

    public double im() {
        return im;
    }

    public String toString() {
        String real = (re == (long) re) ? String.format("%d", (long) re) : String.format("%.2f", re);
        String imag = (im == (long) im) ? String.format("%d", (long) im) : String.format("%.2f", im);

        if (re == 0 && im == 0) return "0";
        if (re == 0 && im == 1) return "i";
        if (re == 0 && im == -1) return "-i";
        if (im == 1) return real + "+i";
        if (im == 0) return real + "";
        if (im == -1) return real + "-i";
        if (re == 0 && im < 0) return imag + "i";
        if (im < 0) return real + "" + imag + "i";
        return real + "+" + imag + "i";
    }

    public static void main(String[] args) {
        Complex3216 z0 = new Complex3216(1.0, 1.0);
        Complex3216 z = z0;
        z = z.times(z).plus(z0);
        z = z.times(z).plus(z0);
        StdOut.println(z);
        Complex3216 z1 = new Complex3216(3, -1);
        Complex3216 z2 = new Complex3216(3, 0);
        Complex3216 z3 = new Complex3216(0, 1);
        Complex3216 z4 = new Complex3216(0, -2);
        Complex3216 z5 = new Complex3216(1, 1);
        Complex3216 z6 = new Complex3216(1, -1);
        System.out.println(z1);
        System.out.println(z2);
        System.out.println(z3);
        System.out.println(z4);
        System.out.println(z5);
        System.out.println(z6);
    }
}
