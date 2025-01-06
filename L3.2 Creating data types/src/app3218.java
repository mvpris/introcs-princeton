public class app3218 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Complex one = new Complex(1, 0);

        for (int i = 0; i < n; i++) {

            // compute root of unity
            double x = Math.cos(2.0 * Math.PI * i / n);
            double y = Math.sin(2.0 * Math.PI * i / n);
            Complex t = new Complex(x, y);
            StdOut.println(t);

            // test mult by computing t^n and comparing to 1 + 0i
            Complex z = one;
            for (int j = 0; j < n; j++) {
                z = z.times(t);
            }

            // compute error
            Complex error = z.minus(one);
            StdOut.println("error = " + error.abs());
            StdOut.println();
        }
    }
}
