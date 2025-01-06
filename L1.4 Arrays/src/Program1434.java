public class Program1434 {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        int n = 5;
        int deadendTimes = 0;
        int deadendSteps = 0;
        for (int t = 0; t < trials; t++) {
            boolean[][] a = new boolean[n][n];
            int x = n / 2, y = n / 2;
//            System.out.println("(" + x + "," + y + ")");
            int steps = 0;
            while (x > 0 && x < n - 1 && y > 0 && y < n - 1) { // Check for dead end and make a random move.
                a[x][y] = true;
                if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
                    deadendTimes++;
                    deadendSteps += steps;
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
                if (x == 0 || x == n - 1 || y == 0 || y == n - 1) {
                    n += 2;
                    boolean[][] b = new boolean[n][n];
                    for (int i = 0; i < a.length; i++) {
                        for (int j = 0; j < a[i].length; j++) {
                            b[i + 1][j + 1] = a[i][j];
                        }
                    }
                    a = b;
                    x++;
                    y++;
                }
//                System.out.println("(" + x + "," + y + ")");
//                System.out.println("steps=" + steps);
//                System.out.println("n=" + n);
//                System.out.println();
            }
        }
        System.out.println(100 * deadendTimes / trials + "% dead ends");
        System.out.println(deadendSteps / deadendTimes + " average steps to a deadend");
    }
}
