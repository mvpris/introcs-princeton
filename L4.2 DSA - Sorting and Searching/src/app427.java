public class app427 {
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] a) {
        printTrace(a, 0, a.length);
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
            if (i == mid) aux[k] = a[j++];
            else if (j == hi) aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
        for (int k = lo; k < hi; k++) {
            a[k] = aux[k];
        }
        printTrace(a, lo, hi);
    }

    public static <T> void printTrace(T[] aux, int lo, int hi) {
        boolean flag = false;
        for (int k = lo; k < hi; k++) {
            if (lo == 0) StdOut.print(aux[k] + " ");
            else {
                if (!flag) {
                    for (int i = 0; i < lo; i++) {
                        StdOut.print("    ");
                        flag = true;
                    }
                    StdOut.print(aux[k] + " ");
                } else StdOut.print(aux[k] + " ");
            }
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
    }
}
