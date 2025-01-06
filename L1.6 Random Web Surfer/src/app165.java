public class app165 {
    public static void main(String[] args) {
        //         Simulate random surfer.
        int n = StdIn.readInt();
        StdIn.readInt();

//        Variable declaration
        int maxTrials = 10000000;
        int page = 0;
        int trials = 0;
        double threshold = Double.parseDouble(args[0]);
        double[] pageRanks = new double[n];
        double[] newPageRanks = new double[n];
        boolean[] convergence = new boolean[n];
        boolean exitFlag = false;

//        Read transition matrix.
        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();
        int[] freq = new int[n];

//            SIMULATION
        for (int t = 0; t < maxTrials; t++) {
//             Make one random move to next page.
//            StdOut.println("t=" + trials);

//            Update pageRanks to newPageRanks
            System.arraycopy(newPageRanks, 0, pageRanks, 0, n);
//            StdOut.printf("%8.5f", pageRanks[i]);
//            StdOut.println();


            double r = Math.random();
            double sum = 0.0;
            for (int j = 0; j < n; j++) { // Find interval containing r.
                sum += p[page][j];
                if (r < sum) {
                    page = j;
                    break;
                }
            }
            freq[page]++;
            trials++;

            for (int i = 0; i < n; i++) {
                newPageRanks[i] = (double) freq[i] / trials;
//                StdOut.printf("%8.5f", newPageRanks[i]);
            }
//            StdOut.println();
//            StdOut.println();

//            Check each page rank for convergence
            for (int i = 0; i < n; i++) {
                if (newPageRanks[i] == 0) break;
                if (Math.abs(newPageRanks[i] - pageRanks[i]) < threshold) {
                    convergence[i] = true;
                }
            }
//            Check if all page ranks converged and implement exit criteria (exitFlag)
            for (int i = 0; i < n; i++) {
                if (!convergence[i]) break;
                else if (i == n - 1) exitFlag = true;
            }
            if (exitFlag) {
                //                StdOut.println("last iteration and final pageranks and newpageranks");
                StdOut.println("Trials=" + trials);

//                Print pageRanks and trials

                StdOut.println("Random page ranks:");
                for (int j = 0; j < n; j++) {
                    StdOut.printf("%8.5f", pageRanks[j]);
                }
                StdOut.println();

//                StdOut.println("newPageRanks");
//                for (int i = 0; i < n; i++) {
//                    StdOut.printf("%8.5f", newPageRanks[i]);
//                }
//                StdOut.println();
                break;
            }
        }
    }
}
