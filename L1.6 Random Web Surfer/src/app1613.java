public class app1613 {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        int n = StdIn.readInt();
        StdIn.readInt();

        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();

        for (int t = 0; t < trials; t++) {
            double[][] newRanks = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++)
                        newRanks[i][j] += p[i][k] * p[k][j];
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++)
                    p[j][k] = newRanks[j][k];
            }
        }

//        Print one row of the matrix (any) i.e. print pageranks
        for (int i = 0; i < n; i++) {
            StdOut.printf("%8.5f", p[0][i]);
        }
        StdOut.println();
    }
}
