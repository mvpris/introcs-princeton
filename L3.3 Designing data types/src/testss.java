public class testss {
    private final double ss;
    private final double[] s1;

    public testss(double[] v1, double s2) {
        ss = s2;
        s1 = new double[32];
        for (int i = 0; i < v1.length; i++) {
            s1[i] = v1[i];
        }
    }

    public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        testss that = (testss) x;
        return (this.ss == that.ss)
                && (this.s1 == that.s1);
    }

    public static void main(String[] args) {
        Complex test = new Complex(1.00000000000000000, 2.0);
        double re = test.re();
        double im = test.im();

        StdOut.println(re);
        StdOut.println(im);
        StdOut.println(test.toString());
    }
}
