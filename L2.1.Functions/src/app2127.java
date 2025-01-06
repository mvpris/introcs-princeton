public class app2127 {
    public static double harmonicSmall(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            double num = 1.0 / i;
            sum += num;
        }
        return sum;
    }

    public static double harmonicLarge(int n) {
        double eulerConstant = 0.577215664901532;
        return Math.log(n) + eulerConstant + 1.0 / (2 * n) - 1.0 / (12 * Math.pow(n, 2)) + 1.0 / (120 * Math.pow(n, 4));
    }

    public static double harmonic(int n) {
        if (n < 100) return harmonicSmall(n);
        else return harmonicLarge(n);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(harmonic(n));
    }
}
