public class app422 {
    public static int search(String key, String[] a) {
        return search(key, a, 0, a.length);
    }

    public static int search(String key, String[] a, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = a[mid].compareTo(key);
            if (cmp > 0) hi = mid;
            else if (cmp < 0) lo = mid + 1;
            else return mid;
        }
        return -1;
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
