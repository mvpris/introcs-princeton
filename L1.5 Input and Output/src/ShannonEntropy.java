public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] x = new int[m + 1];
        int count = 0;
        double h = 0.0;
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            x[i]++;
            count++;
        }

        for (int i = 1; i <= m; i++) {
            double p = (double) x[i] / count;
            if (x[i] > 0) {
                h -= p * Math.log(p) / Math.log(2);
            }
        }
        StdOut.printf("%.4f\n", h);
    }
}
