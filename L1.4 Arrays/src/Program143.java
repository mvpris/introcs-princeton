public class Program143 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] x = new double[n];
        double[] y = new double[n];
        double d1 = 0.0;
        for (int i = 0; i < n; i++) {
            x[i] = Math.random();
            y[i] = Math.random();
            d1 += Math.pow(y[i] - x[i], 2);
        }
        double d = Math.sqrt(d1);
        System.out.println("Euclidean distance=" + d);
    }
}
