public class app218 {
    public static double harmonic(int n) {
        double sum = 0.0;
        StdOut.println("    sum = " + sum);
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
            StdOut.println("    sum = " + sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            int arg = Integer.parseInt(args[i]);
            StdOut.println("i = " + i);
            StdOut.println("arg = " + args[i]);
            StdOut.println("harmonic(" + i + ")");
            double value = harmonic(arg);
            StdOut.println("value = " + value);
        }
    }
}
