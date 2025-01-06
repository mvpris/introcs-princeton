public class app4138 {
    public static void findLargestBlackSquare(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int maxSize = 0;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1;
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    if (dp[i][j] > maxSize) {
                        maxSize = dp[i][j];
                        maxRow = i;
                        maxCol = j;
                    }
                }
            }
        }

        int topLeftRow = maxRow - maxSize + 1;
        int topLeftCol = maxCol - maxSize + 1;
        int bottomRightRow = maxRow;
        int bottomRightCol = maxCol;

        StdOut.println("Top left corner: (" + topLeftRow + ", " + topLeftCol + ")");
        StdOut.println("Bottom right corner: (" + bottomRightRow + ", " + bottomRightCol + ")");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StdOut.print(dp[i][j] + "  ");
            }
            StdOut.println();
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 1, 1, 0}
        };

        findLargestBlackSquare(matrix);
    }
}
