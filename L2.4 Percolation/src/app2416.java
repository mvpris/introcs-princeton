public class app2416 {
    static boolean done = false;

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

    public static boolean[][] flow(boolean[][] isOpen) { // Fill every site reachable from the top row.
        int n = isOpen.length;
        boolean[][] isFull = new boolean[n][n];
        for (int j = 0; j < n; j++)
            flow(isOpen, isFull, 0, j);
        return isFull;
    }

    public static void flow(boolean[][] isOpen,
                            boolean[][] isFull, int i, int j) { // Fill every site reachable from (i, j).
        if (done) return;
        int n = isFull.length;
        if (i < 0 || i >= n) return;
        if (j < 0 || j >= n) return;
        if (!isOpen[i][j]) return;
        if (isFull[i][j]) return;
        isFull[i][j] = true;
        if (isFull[n - 1][j]) done = true;
        flow(isOpen, isFull, i + 1, j); // Down.
        flow(isOpen, isFull, i, j + 1); // Right.
        flow(isOpen, isFull, i, j - 1); // Left.
        flow(isOpen, isFull, i - 1, j); // Up.
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
