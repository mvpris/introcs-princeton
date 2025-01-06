public class app156 {
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        int n = a.length;
        StdOut.print(a[0] + " ");
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}
