public class app4132 {
    public static boolean youngTable(int[][] table, int x) {
        int n = table.length;
        int i = 0;
        int j = n - 1; // Start from top right corner
        while (i < n && j >= 0) {
            if (table[i][j] == x) return true;
            else if (table[i][j] > x) j--; // Move left
            else i++; // Move down
        }
        return false; // If not found
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        in.readInt();
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = in.readInt();
            }
        }
        int x = Integer.parseInt(args[1]);
        StdOut.println(youngTable(table, x));
    }
}
