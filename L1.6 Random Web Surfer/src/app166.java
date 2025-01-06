public class app166 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        StdIn.readInt();

//        Variable declaration
        int maxTrials = 10000000;
        int trials = 0;
        double threshold = Double.parseDouble(args[0]);
        boolean[] convergence = new boolean[n];
        boolean exitFlag = false;


//        Read transition matrix.
        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();

        double[] ranks = new double[n];
        ranks[0] = 1.0;

//        SIMULATION
        for (int t = 0; t < maxTrials; t++) {
            double[] newRanks = new double[n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++)
                    newRanks[j] += ranks[k] * p[k][j];
            }

//            Check each page rank for convergence
            for (int i = 0; i < n; i++) {
                if (newRanks[i] == 0) break;
                if (Math.abs(newRanks[i] - ranks[i]) < threshold) {
                    convergence[i] = true;
                }
            }

//            Check if all page ranks converged and implement exit criteria (exitFlag)
            for (int i = 0; i < n; i++) {
                if (!convergence[i]) break;
                else if (i == n - 1) exitFlag = true;
            }

//            Update ranks[].
            System.arraycopy(newRanks, 0, ranks, 0, n);
            trials++;

//                Print page ranks and trials
            if (exitFlag) {
                StdOut.println("Trials=" + trials);
                StdOut.println("Markov page ranks:");
                for (int j = 0; j < n; j++) {
                    StdOut.printf("%8.5f", ranks[j]);
                }
                StdOut.println();
                break;
            }
        }
    }
}
