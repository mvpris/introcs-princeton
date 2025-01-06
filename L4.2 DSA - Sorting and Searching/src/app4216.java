public class app4216 {
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] a) {
        T[] aux = (T[]) new Comparable[a.length];
        sort(a, aux);
    }

    private static <T extends Comparable<T>> void sort(T[] a, T[] aux) {
        int n = a.length;
        for (int size = 1; size < n; size *= 2) {
            for (int lo = 0; lo < n - size; lo += 2 * size) {
                int mid = lo + size - 1;
                int hi = Math.min(lo + 2 * size - 1, n - 1);

                // Merge step within the sort method
                System.arraycopy(a, lo, aux, lo, hi - lo + 1);

                int i = lo, j = mid + 1;
                for (int k = lo; k <= hi; k++) {
                    if (i > mid) a[k] = aux[j++];
                    else if (j > hi) a[k] = aux[i++];
                    else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
                    else a[k] = aux[i++];
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        for (String s : a) StdOut.print(s + " ");
        StdOut.println();
    }
}
