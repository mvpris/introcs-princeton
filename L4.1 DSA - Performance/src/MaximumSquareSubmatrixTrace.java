public class MaximumSquareSubmatrixTrace {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int largest = 0;
        int[][] dp = new int[a.length + 1][a.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= a.length; j++) {
                if (a[i - 1][j - 1] == 1) {
                    int min = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(min, dp[i - 1][j - 1]) + 1;
                }
                if (dp[i][j] > largest) largest = dp[i][j];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                StdOut.print(dp[i][j] + "  ");
            }
            StdOut.println();
        }
        return largest;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        while (!StdIn.isEmpty()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                StdOut.print(a[i][j] + "  ");
            }
            StdOut.println();
        }
        StdOut.println();
        StdOut.println("\n" + size(a));
    }
}
