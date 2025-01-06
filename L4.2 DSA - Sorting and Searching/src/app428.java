public class app428 {
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] a) {
        T[] aux = (T[]) new Comparable[a.length];
        sort(a, aux, 0, a.length);
    }

    private static <T extends Comparable<T>> void sort(T[] a, T[] aux, int lo, int hi) {
        if (hi - lo <= 1) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++) {
            if (lo == 0 && hi == a.length) StdOut.printf("i=%-2dj=%-2dk=%-2d", i, j, k);
            if (i == mid) aux[k] = a[j++];
            else if (j == hi) aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else aux[k] = a[i++];
            if (lo == 0 && hi == a.length) {
                StdOut.printf("aux[k]=%6s", aux[k]);
                printTrace(a);
            }
        }
        for (int k = lo; k < hi; k++) {
            a[k] = aux[k];
        }
    }

    public static <T> void printTrace(T[] a) {
        for (T s : a) StdOut.printf("%7s", s);
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        StdOut.printf("%25s", " ");
        printTrace(a);
        sort(a);
    }
}
