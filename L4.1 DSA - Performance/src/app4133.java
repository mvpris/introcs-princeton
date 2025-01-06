public class app4133 {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7};
        int n = a.length;
        for (int i = 0; i < n; i++) StdOut.print(a[i] + " ");
        StdOut.println();

        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }
        for (int i = 0; i < n; i++) StdOut.print(a[i] + " ");
        StdOut.println();

        int k = Integer.parseInt(args[0]);
        for (int i = 0; i < (n - k) / 2; i++) {
            int temp = a[i];
            a[i] = a[n - k - 1 - i];
            a[n - k - 1 - i] = temp;
        }
        for (int i = 0; i < n; i++) StdOut.print(a[i] + " ");
        StdOut.println();

        for (int i = 0; i < k / 2; i++) {
            int temp = a[n - k + i];
            a[n - k + i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }
        for (int i = 0; i < n; i++) StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
