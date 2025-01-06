public class app163 {
    public static void main(String[] args) {
        double pLeap = Double.parseDouble(args[0]);
        double pLink = 1.0 - pLeap;
        int n = StdIn.readInt();
        int[][] counts = new int[n][n];
        int[] outDegrees = new int[n];
        while (!StdIn.isEmpty()) { // Accumulate link counts.
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            outDegrees[i]++;
            counts[i][j]++;
        }

//        Print link counts
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", counts[i][j]);
            }
            StdOut.println();
        }
        StdOut.println();

//        Print outDegrees
        for (int i = 0; i < n; i++) {

            System.out.printf("%d \n", outDegrees[i]);
        }
        StdOut.println();

//        Print transition matrix
        StdOut.println(n + " " + n);
        for (int i = 0; i < n; i++) { // Print probability distribution for row i.
            for (int j = 0; j < n; j++) { // Print probability for row i and column j.
                double p;
                if (outDegrees[i] == 0) {
                    p = 1.0 / n;
                } else
                    p = pLink * counts[i][j] / outDegrees[i] + pLeap / n;
                StdOut.printf("%8.5f", p);
            }
            StdOut.println();
        }
    }
}
