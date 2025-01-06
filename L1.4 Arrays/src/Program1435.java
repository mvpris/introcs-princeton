public class Program1435 {
    public static void main(String[] args) {
        //         Do trials random self-avoiding
        //         walks in an n-by-n lattice.
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int escapeTimes = 0;
        int deadendTimes = 0;
        int escapeSteps = 0;
        int deadendSteps = 0;
        for (int t = 0; t < trials; t++) {
            boolean[][][] a = new boolean[n][n][n];
            int x = n / 2, y = n / 2, z = n / 2;
            int steps = 0;
            while (x > 0 && x < n - 1 && y > 0 && y < n - 1 && z > 0 && z < n - 1) { // Check for dead end and make a random move.
                a[x][y][z] = true;
                if (a[x - 1][y][z] && a[x + 1][y][z] && a[x][y - 1][z] && a[x][y + 1][z]
                        && a[x][y][z - 1] && a[x][y][z + 1]) {
                    deadendTimes++;
                    deadendSteps += steps;
                    break;
                }
                double r = Math.random();
                if (r < 1 / 6.0) {
                    if (!a[x + 1][y][z]) x++;
                } else if (r < 2 / 6.0) {
                    if (!a[x - 1][y][z]) x--;
                } else if (r < 3 / 6.0) {
                    if (!a[x][y + 1][z]) y++;
                } else if (r < 4 / 6.0) {
                    if (!a[x][y - 1][z]) y--;
                } else if (r < 5 / 6.0) {
                    if (!a[x][y][z + 1]) z++;
                } else {
                    if (!a[x][y][z - 1]) z--;
                }
                steps++;
            }
            if (x == 0 || x == n - 1 || y == 0 || y == n - 1 || z == 0 || z == n - 1) {
                escapeSteps += steps;
                escapeTimes++;
            }
        }
        System.out.println("deadendTimes=" + deadendTimes);
        System.out.println("escapeTimes=" + escapeTimes);
        System.out.println(100.0 * deadendTimes / trials + "% dead ends");
        System.out.println(escapeSteps / escapeTimes + " average steps to escape");
        System.out.println(deadendSteps / deadendTimes + " average steps to a deadend");
    }
}
