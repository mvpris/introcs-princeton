public class app2418boolrand {
    public static boolean[][][] random(int n, double p) {
        boolean[][][] a = new boolean[n][n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    a[i][j][k] = StdRandom.bernoulli(p);
        return a;
    }

    public static boolean[][][] readBoolean3D() {
        int m = StdIn.readInt();
        int n = StdIn.readInt();
        int p = StdIn.readInt();
        boolean[][][] a = new boolean[m][n][p];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < p; k++)
                    a[i][j][k] = StdIn.readBoolean();
        return a;
    }

    public static void main(String[] args) {

    }
}
