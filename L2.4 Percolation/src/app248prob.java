public class app248prob {
    public static double estimate(int n, double p, int trials) {
//      Generate trials random n-by-n systems;
//      return empirical percolation probability estimate.
        int count = 0;
        for (int t = 0; t < trials; t++) { // Generate one random n-by-n boolean matrix.
            boolean[][] isOpen = Percolation.random(n, p);
            if (Percolation.percolates(isOpen)) count++;
        }
        return (double) count / trials;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        int trials = Integer.parseInt(args[2]);
        double q = estimate(n, p, trials);
        StdOut.println(q);
    }
}
