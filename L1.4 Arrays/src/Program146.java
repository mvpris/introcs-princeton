public class Program146 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double r = Math.random();
                if (r < 0.5) {
                    a[i][j] = true;
                    System.out.print("*  ");
                } else System.out.print("   ");
            }
            System.out.println();
        }
    }
}
