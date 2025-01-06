public class app2215 {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);

        int[] dice1 = {1, 2, 3, 4, 5, 6};
        int nd1 = StdStats.max(dice1) + StdStats.max(dice1);
        int[] freq1 = new int[nd1 + 1];

        int[] dice21 = {1, 3, 4, 5, 6, 8};
        int[] dice22 = {1, 2, 2, 3, 3, 4};
        int nd2 = StdStats.max(dice21) + StdStats.max(dice22);
        int[] freq2 = new int[nd2 + 1];

        for (int i = 0; i < trials; i++) {
            int r1 = StdRandom.uniformInt(6);
            int r2 = StdRandom.uniformInt(6);
            int sum1 = dice1[r1] + dice1[r2];
            int sum2 = dice21[r1] + dice22[r2];
            freq1[sum1]++;
            freq2[sum2]++;
        }

        for (int i = 0; i <= nd1; i++)
            if (freq2[i] != 0) StdOut.printf("%8.5f", (double) freq1[i] / trials);
        StdOut.println();

        for (int i = 0; i <= nd2; i++) {
            if (freq2[i] != 0) StdOut.printf("%8.5f", (double) freq2[i] / trials);
        }
        StdOut.println();
    }
}
