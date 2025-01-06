public class Program1421 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int deadEnds = 0;
        int area = 0;
        for (int t = 0; t < trials; t++) {
            boolean[][] a = new boolean[n][n];
            int x = n / 2, y = n / 2;
            int L = 0;
            int l = 0;
            while (x > 0 && x < n - 1 && y > 0 && y < n - 1) { // Check for dead end and make a random move.
                a[x][y] = true;
                if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
                    deadEnds++;
                    break;
                }
                double r = Math.random();
                if (r < 0.25) {
                    if (!a[x + 1][y]) {
                        x++;
                        if (Math.abs(x) > L) L = x;
                    }
                } else if (r < 0.50) {
                    if (!a[x - 1][y]) {
                        x--;
                        if (Math.abs(x) > L) L = x;
                    }
                } else if (r < 0.75) {
                    if (!a[x][y + 1]) {
                        y++;
                        if (Math.abs(y) > l) l = y;
                    }
                } else {
                    if (!a[x][y - 1]) {
                        y--;
                        if (Math.abs(y) > l) l = y;
                    }
                }
            }
            area += L * l;
        }
        System.out.println(100 * deadEnds / trials + "% dead ends");
        System.out.println(area / trials + " average area");
    }
}
