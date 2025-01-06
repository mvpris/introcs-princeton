public class MergesortString {
    public static void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length);
    }

    private static void sort(String[] a, String[] aux, int lo, int hi) {
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
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        for (String s : a) StdOut.print(s + " ");
        StdOut.println();
    }
}
