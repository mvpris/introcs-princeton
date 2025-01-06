public class PercolationVertical {
    public static boolean[][] random(int n, double p) {
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = StdRandom.bernoulli(p);
        return a;
    }

    public static void show(boolean[][] a, boolean which) {
        int n = a.length;
        StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-1, n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == which)
                    StdDraw.filledSquare(j, n - i - 1, 0.5);
    }

    public static boolean[][] flow(boolean[][] isOpen) {
        int n = isOpen.length;
        boolean[][] isFull = new boolean[n][n];
//        Implementation for isFull matrix
        for (int j = 0; j < n; j++) {
            isFull[0][j] = isOpen[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isFull[i][j] = isOpen[i][j] && isFull[i - 1][j];
            }
        }
        return isFull;
    }

    public static boolean percolates(boolean[][] isOpen) {
        boolean[][] isFull = flow(isOpen);
        int n = isOpen.length;
        for (int j = 0; j < n; j++) {
            if (isFull[n - 1][j]) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        boolean[][] isOpen = StdArrayIO.readBoolean2D();
        StdArrayIO.print(flow(isOpen));
        System.out.println(percolates(isOpen));
    }
}
