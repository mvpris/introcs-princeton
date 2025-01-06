public class app241b {
    public static boolean[][] hadamardMatrix(int n) {
        boolean[][] a = new boolean[n][n];
        a[0][0] = true;
        for (int k = 1; k < n; k += k) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    a[i][j + k] = a[i][j];
                    a[i + k][j] = a[i][j];
                    a[i + k][j + k] = !a[i][j];
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
    }
}
