public class app2335 {
    public static String lcs(String s, String t, String u) { // Compute length of LCS for all subproblems.
        int m = s.length(), n = t.length(), p = u.length();
        int[][][] opt = new int[m + 1][n + 1][p + 1];
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                for (int k = p - 1; k >= 0; k--)
                    if (s.charAt(i) == t.charAt(j) && t.charAt(j) == u.charAt(k))
                        opt[i][j][k] = opt[i + 1][j + 1][k + 1] + 1;
                    else
                        opt[i][j][k] = Math.max(opt[i + 1][j][k], Math.max(opt[i][j + 1][k], opt[i][j][k + 1]));
// Recover LCS itself.
        String lcs = "";
        int i = 0, j = 0, k = 0;
        while (i < m && j < n && k < p) {
            if (s.charAt(i) == t.charAt(j) && t.charAt(j) == u.charAt(k)) {
                lcs += s.charAt(i);
                i++;
                j++;
                k++;
            } else if (opt[i + 1][j][k] >= opt[i][j + 1][k] && opt[i + 1][j][k] >= opt[i][j][k + 1]) i++;
            else if (opt[i][j + 1][k] >= opt[i][j][k + 1]) j++;
            else k++;
        }
        
        return lcs;
    }

    public static void main(String[] args) {
        StdOut.println(lcs(args[0], args[1], args[2]));
    }
}
