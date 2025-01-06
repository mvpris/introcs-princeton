public class Program1419 {
    public static void main(String[] args) {
        boolean[][] a =
                {
                        {true, false},
                        {false, false},
                };
        boolean[][] b =
                {
                        {true, false},
                        {true, false},
                };

        int m = a.length;
        boolean[][] c = new boolean[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    c[i][j] = c[i][j] || (a[i][k] && b[k][j]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

    }
}
