public class app2419 {
    private boolean[][] vertical;
    private boolean[][] horizontal;
    private boolean[][] isFull;
    private int n;

    public app2419(int n, double p) {
        this.n = n;
        vertical = new boolean[n][n - 1];
        horizontal = new boolean[n - 1][n];
        isFull = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                vertical[i][j] = StdRandom.bernoulli(p);
                if (i < n - 1) {
                    horizontal[i][j] = StdRandom.bernoulli(p);
                }
            }
        }
    }

    public void flow(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n) return;
        if (isFull[i][j]) return;
        isFull[i][j] = true;
        if (j > 0 && vertical[i][j - 1]) flow(i, j - 1); // Left.
        if (j < n - 1 && vertical[i][j]) flow(i, j + 1); // Right.
        if (i > 0 && horizontal[i - 1][j]) flow(i - 1, j); // Up.
        if (i < n - 1 && horizontal[i][j]) flow(i + 1, j); // Down.
    }

    public boolean percolates() {
        for (int j = 0; j < n; j++) {
            flow(0, j);
        }
        for (int j = 0; j < n; j++) {
            if (isFull[n - 1][j]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // size of the grid
        double p = Double.parseDouble(args[1]); // probability of an edge being open
        app2419 tg = new app2419(n, p);
        System.out.println(tg.percolates());
    }
}
