public class app2119 {
    public static int[] histogram(int[] a, int m) {
        int[] b = new int[m];
        for (int i = 0; i < a.length; i++) {
            b[a[i]]++;
        }

        return b;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 4, 5, 5, 1, 7, 1};
        int m = f21.max(a) + 1;
        StdOut.println(m - 1);
        f21.print1D(a);
        int[] histogram = histogram(a, m);
        f21.print1D(histogram);
    }
}
