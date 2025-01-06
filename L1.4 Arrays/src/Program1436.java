public class Program1436 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int totalSteps = 0;
        for (int t = 0; t < trials; t++) {
            boolean[][] a = new boolean[n][n];
            int x = n / 2, y = n / 2;
            int steps = 0;
            int count = 0;
            while (count != n * n) { // Check if all cells are visited
                if (!a[x][y]) count++; // Check if cell is not visited
                a[x][y] = true;
                double r = Math.random();
                if (r < 1 / 4.0) x++;
                else if (r < 2 / 4.0) x--;
                else if (r < 3 / 4.0) y++;
                else y--;
                steps++;
                if (x == -1) x++;
                else if (x == n) x--;
                else if (y == -1) y++;
                else if (y == n) y--;
            }
            totalSteps += steps;
        }
        System.out.println(totalSteps / trials + " steps taken before all cells are touched");
    }
}
