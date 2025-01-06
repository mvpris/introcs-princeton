public class app4134old {
    public static void main(String[] args) {
        int[] a = {3, 5, 2, 4, 6, 4};
        int n = a.length;
        boolean[] b = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            if (!b[a[i - 1]]) b[a[i - 1]] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!b[i]) {
                StdOut.println("a) " + i);
                break;
            }
        }


        int[] c = {3, 4, 2, 5, 2, 1};
        int m = c.length;
        boolean[] d = new boolean[m];

        for (int i = 0; i < m; i++) {
            if (d[c[i]]) {
                StdOut.println("b) " + c[i]);
                break;
            }
            d[c[i]] = true;
        }

//        for (int i = 0; i < m; i++) {
//            StdOut.print("i=" + i + ":" + d[i] + " ");
//        }
//        StdOut.println();


        int[] e = {3, 4, 2, 3, 2, 3};
        int p = e.length;
        boolean[] f = new boolean[m];

        for (int i = 0; i < p; i++) {
            if (f[e[i]]) {
                StdOut.println("c) " + e[i]);
                break;
            }
            f[e[i]] = true;
        }
    }
}
