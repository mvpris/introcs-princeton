import java.util.Arrays;

public class app2336 {
    public static String lcs(int[] a, int b[]) { // Compute length of LCS for all subproblems.
        int m = a.length, n = b.length;
        int[][] opt = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                if (a[i] == b[j])
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
// Recover LCS itself.
        String lcs = "";
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a[i] == b[j]) {
                lcs += a[i] + " ";
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1]) i++;
            else j++;
        }
        return lcs;
    }

    public static int[] removeDuplicates(int[] a, int n) {
        if (n == 0 || n == 1) throw new IllegalArgumentException("Array empty or has only one element");

        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) temp[j++] = a[i];
        }
        temp[j++] = a[n - 1];

        int[] result = new int[j];
        for (int i = 0; i < j; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {10, 0, 0, 0, -2, 20, 30, 30, 23, 24, 31, 11, 12, 25, 26, 20, 21, 22, 32};
        int n = a.length;
        int[] b = removeDuplicates(a, n);
        Arrays.sort(b);
        StdOut.println(lcs(a, b));
    }
}
