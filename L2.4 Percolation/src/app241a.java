public class app241a {
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) return 0;
        else if (b == 0) return Math.abs(a);
        int absa = Math.abs(a);
        int absb = Math.abs(b);
        while (absa % absb != 0) {
            int t = absa;
            absa = absb;
            absb = t % absb;
        }
        return absb;
    }

    public static boolean areRelativelyPrime(int a, int b) {
        return (gcd(a, b) == 1);
    }

    public static boolean[][] relMatrix(int n) {
        boolean[][] a = new boolean[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = areRelativelyPrime(i, j);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdArrayIO.print(relMatrix(n));
    }
}
