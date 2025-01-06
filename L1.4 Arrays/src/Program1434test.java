public class Program1434test {
    public static void main(String[] args) {
        int n = 3;
        int m = 5;
        int n1 = 1;
        int m1 = 1;
        int[][] a = new int[n][n];
        int[][] b = new int[m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = n1;
                n1++;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = m1;
                m1++;
                System.out.printf("%2d ", b[i][j]);
            }
            System.out.println();
        }
        System.out.print(a[1][2] + " ");
        a = b;
        System.out.print(a[1][2] + " ");
        System.out.print(b[1][2] + " ");
        System.out.print(a[1][4] + " ");
        System.out.println();
    }
}
