public class Program1432 {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);

        boolean[][] a = new boolean[m + 2][n + 2];
        int[][] b = new int[m + 2][n + 2];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                double r = Math.random();
                if (r < p) a[i][j] = true;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a[i][j]) System.out.print("*  ");
                else System.out.print(".  ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a[i][j]) {
                    if (!a[i - 1][j - 1]) b[i - 1][j - 1]++;
                    if (!a[i - 1][j + 1]) b[i - 1][j + 1]++;
                    if (!a[i + 1][j - 1]) b[i + 1][j - 1]++;
                    if (!a[i + 1][j + 1]) b[i + 1][j + 1]++;
                    if (!a[i - 1][j]) b[i - 1][j]++;
                    if (!a[i + 1][j]) b[i + 1][j]++;
                    if (!a[i][j - 1]) b[i][j - 1]++;
                    if (!a[i][j + 1]) b[i][j + 1]++;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a[i][j]) System.out.print("*  ");
                else System.out.print(b[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
