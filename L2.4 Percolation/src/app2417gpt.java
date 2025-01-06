public class app2417gpt {
    private boolean[][] vertical;
    private boolean[][] horizontal;
    private int n;

    public app2417gpt(int n, double p) {
        this.n = n;
        vertical = new boolean[n][n - 1];
        horizontal = new boolean[n - 1][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                vertical[i][j] = StdRandom.bernoulli(p);
                if (i < n - 1) {
                    horizontal[i][j] = StdRandom.bernoulli(p);
                }
            }
        }
    }

    public boolean isOpen(int i, int j) {
        return vertical[i][j] || horizontal[i][j];
    }

    public void flow(boolean[][] isFull, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n) return;
        if (isFull[i][j]) return;
        isFull[i][j] = true;
        if (j > 0 && vertical[i][j - 1]) flow(isFull, i, j - 1); // Left.
        if (j < n - 1 && vertical[i][j]) flow(isFull, i, j + 1); // Right.
        if (i > 0 && horizontal[i - 1][j]) flow(isFull, i - 1, j); // Up.
        if (i < n - 1 && horizontal[i][j]) flow(isFull, i + 1, j); // Down.
    }

    public boolean percolates() {
        boolean[][] isFull = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            flow(isFull, 0, j);
        }
        for (int j = 0; j < n; j++) {
            if (isFull[n - 1][j]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // size of the grid (try n=100)
        double p = Double.parseDouble(args[1]); // probability of an edge being open (try p=0.5,0.51)
        app2417gpt bp = new app2417gpt(n, p);
        System.out.println(bp.percolates());
    }
}
