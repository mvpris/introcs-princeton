public class app241c {
    public static int[][] pascalTriangle(int n) {
        //        Create & initialise array
        int[][] a = new int[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            a[i] = new int[i + 2];
            a[i][0] = 0;
        }
        a[1][1] = 1;

//        Build Pascal triangle array
        for (int i = 2; i < n + 1; i++) {
            for (int k = 1; k < a[i].length - 1; k++) {
                a[i][k] = a[i - 1][k] + a[i - 1][k - 1];
            }
        }
        return a;
    }

    public static boolean[][] pascalTriOddBoolean(int n) {
        int[][] a = pascalTriangle(n);
        boolean[][] b = new boolean[n + 1][n + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int k = 1; k < a[i].length - 1; k++) {
                b[i][k] = (a[i][k] % 2 != 0);
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
    }
}
