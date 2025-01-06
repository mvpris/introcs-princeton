public class app223 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] uniformInteger = new int[n];
        double[] uniformDou = new double[n];
        boolean[] bernoulli = new boolean[n];
        double[] gaussian = new double[n];
        int[] discrete = new int[n];

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

//        StdRandom
        for (int i = 0; i < n; i++) {
            uniformInteger[i] = StdRandom.uniformInt(n);
            uniformDou[i] = StdRandom.uniformDouble(0, n);
            bernoulli[i] = StdRandom.bernoulli();
            gaussian[i] = StdRandom.gaussian();
            discrete[i] = StdRandom.discrete(a);
        }

//        StdStats.max
        StdOut.println("StdStats.max");
        StdOut.print(StdStats.max(uniformInteger) + " ");
        StdOut.print(StdStats.max(uniformDou) + " ");
        StdOut.print(StdStats.max(gaussian) + " ");
        StdOut.print(StdStats.max(discrete) + " ");
        StdOut.println();

//        StdStats.min
        StdOut.println("StdStats.min");
        StdOut.print(StdStats.min(uniformInteger) + " ");
        StdOut.print(StdStats.min(uniformDou) + " ");
        StdOut.print(StdStats.min(gaussian) + " ");
        StdOut.print(StdStats.min(discrete) + " ");
        StdOut.println();

//        StdStats.mean
        StdOut.println("StdStats.mean");
        StdOut.print(StdStats.mean(uniformInteger) + " ");
        StdOut.print(StdStats.mean(uniformDou) + " ");
        StdOut.print(StdStats.mean(gaussian) + " ");
        StdOut.print(StdStats.mean(discrete) + " ");
        StdOut.println();

//        StdStats.var
        StdOut.println("StdStats.var");
        StdOut.print(StdStats.var(uniformInteger) + " ");
        StdOut.print(StdStats.var(uniformDou) + " ");
        StdOut.print(StdStats.var(gaussian) + " ");
        StdOut.print(StdStats.var(discrete) + " ");
        StdOut.println();

//        StdStats.stddev
        StdOut.println("StdStats.stddev");
        StdOut.print(StdStats.stddev(uniformInteger) + " ");
        StdOut.print(StdStats.stddev(uniformDou) + " ");
        StdOut.print(StdStats.stddev(gaussian) + " ");
        StdOut.print(StdStats.stddev(discrete) + " ");
        StdOut.println();
        
    }
}
