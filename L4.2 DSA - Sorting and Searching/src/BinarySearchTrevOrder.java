public class BinarySearchTrevOrder {
    public static <T extends Comparable<T>> int search(T key, T[] a, boolean ascending) {
        return search(key, a, 0, a.length, ascending);
    }

    public static <T extends Comparable<T>> int search(T key, T[] a, int lo, int hi, boolean ascending) {
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo) / 2;
        int cmp = a[mid].compareTo(key);

        if (cmp == 0) return mid;

        if (ascending) {
            if (cmp > 0) return search(key, a, lo, mid, true);
            return search(key, a, mid + 1, hi, true);
        } else {
            if (cmp < 0) return search(key, a, lo, mid, false);
            return search(key, a, mid + 1, hi, false);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {2, 3, 5, 8, 12, 24, 32};
        Integer[] b = {32, 24, 12, 8, 5, 3, 2};
        Integer key = Integer.parseInt(args[0]);
        int indexAsc = search(key, a, true);
        int indexDsc = search(key, b, false);
        StdOut.println("indexAsc=" + indexAsc);
        StdOut.println("indexDsc=" + indexDsc);

    }
}
