public class app2118 {
    public static boolean[][] readBoolean2D() {
        int m = StdIn.readInt();
        int n = StdIn.readInt();
        boolean[][] b = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = StdIn.readBoolean();
            }
        }

        return b;
    }

    public static void main(String[] args) {
        boolean[][] matrix = readBoolean2D();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                StdOut.printf("%6b", matrix[i][j]);
            }
            StdOut.println();
        }

    }
}
