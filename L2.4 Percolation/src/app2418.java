public class app2418 {
    public static boolean[][][] flow(boolean[][][] isOpen) { // Fill every site reachable from the top row.
        int n = isOpen.length;
        boolean[][][] isFull = new boolean[n][n][n];
        for (int j = 0; j < n; j++)
            for (int k = 0; k < n; k++)
                flow(isOpen, isFull, 0, j, k);
        return isFull;
    }

    public static void flow(boolean[][][] isOpen,
                            boolean[][][] isFull, int i, int j, int k) { // Fill every site reachable from (i, j).
        int n = isFull.length;
        if (i < 0 || i >= n) return;
        if (j < 0 || j >= n) return;
        if (k < 0 || k >= n) return;
        if (!isOpen[i][j][k]) return;
        if (isFull[i][j][k]) return;
        isFull[i][j][k] = true;
        flow(isOpen, isFull, i + 1, j, k); // Down.
        flow(isOpen, isFull, i, j + 1, k); // Right.
        flow(isOpen, isFull, i, j, k + 1); // Front.
        flow(isOpen, isFull, i, j - 1, k); // Left.
        flow(isOpen, isFull, i, j, k + 1); // Back.
        flow(isOpen, isFull, i - 1, j, k); // Up.
    }

    public static boolean percolates(boolean[][][] isOpen) {
        boolean[][][] isFull = flow(isOpen);
        int n = isOpen.length;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (isFull[n - 1][j][k]) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        boolean[][][] isOpen = app2418boolrand.random(n, p);
//        StdArrayIO.print(flow(isOpen));
        System.out.println(percolates(isOpen));
    }
}
