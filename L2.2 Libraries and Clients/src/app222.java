public class app222 {
    public static double sinh(double x) {
        return (Math.exp(x) - Math.exp(-x)) / 2.0;
    }

    public static double cosh(double x) {
        return (Math.exp(x) + Math.exp(-x)) / 2.0;
    }

    public static double tanh(double x) {
        return sinh(x) / cosh(x);
    }

    public static double coth(double x) {
        return cosh(x) / sinh(x);
    }

    public static double sech(double x) {
        return 1.0 / cosh(x);
    }

    public static double csch(double x) {
        return 1.0 / sinh(x);
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.printf("%.4f ", sinh(x));
        StdOut.printf("%.4f ", cosh(x));
        StdOut.printf("%.4f ", tanh(x));
        StdOut.printf("%.4f ", coth(x));
        StdOut.printf("%.4f ", sech(x));
        StdOut.printf("%.4f ", csch(x));
        StdOut.println();
    }
}
