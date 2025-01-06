public class app2131 {
    public static double evaluate(double x, double p[]) {
        double result = 0;
        for (int i = p.length - 1; i >= 0; i--) {
            result = p[i] + (x * result);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double[] p = new double[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] / i;
        }

        while (!StdIn.isEmpty()) {
            double x = StdIn.readInt();
            StdOut.println(evaluate(x, p));
            StdOut.println(Math.exp(x));
            StdOut.println();
        }
    }
}
