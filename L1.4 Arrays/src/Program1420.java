public class Program1420 {
    public static void main(String[] args) {
//         Do trials random self-avoiding
//         walks in an n-by-n lattice.
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int deadEndsE = 0;
        int deadEndsD = 0;
        int escape = 0;
        int deadend = 0;
        for (int t = 0; t < trials; t++) {
            boolean[][] a = new boolean[n][n];
            int x = n / 2, y = n / 2;
            int steps = 0;
            while (x > 0 && x < n - 1 && y > 0 && y < n - 1) { // Check for dead end and make a random move.
                a[x][y] = true;
                if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
                    deadEndsD++;
                    deadend += steps;
                    break;
                }
                double r = Math.random();
                if (r < 0.25) {
                    if (!a[x + 1][y]) x++;
                } else if (r < 0.50) {
                    if (!a[x - 1][y]) x--;
                } else if (r < 0.75) {
                    if (!a[x][y + 1]) y++;
                } else {
                    if (!a[x][y - 1]) y--;
                }
                steps++;
            }
            if (x == 0 || x == n - 1 || y == 0 || y == n - 1) {
                escape += steps;
                deadEndsE++;
            }
        }
        System.out.println(100 * deadEndsD / trials + "% dead ends");
        System.out.println(escape / deadEndsE + " average steps to escape");
        System.out.println(deadend / deadEndsD + " average steps to a deadend");
    }
}
