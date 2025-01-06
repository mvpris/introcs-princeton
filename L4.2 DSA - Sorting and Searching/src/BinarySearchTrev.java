public class BinarySearchTrev {
    public static <T extends Comparable<T>> int search(T key, T[] a) {
        return search(key, a, 0, a.length);
    }

    public static <T extends Comparable<T>> int search(T key, T[] a, int lo, int hi) {
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo) / 2;
        int cmp = a[mid].compareTo(key);

        if (cmp == 0) return mid;
        if (cmp > 0) return search(key, a, lo, mid);
        return search(key, a, mid + 1, hi);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (search(key, a) < 0) StdOut.println(key);
        }
    }
}
