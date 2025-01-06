public class app423 {
    public static int search(String key, String[] a) {
        return search(key, a, 0, a.length);
    }

    public static int search(String key, String[] a, int lo, int hi) {
        if (hi <= lo) return -lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = a[mid].compareTo(key);
        if (cmp > 0) return search(key, a, lo, mid);
        else if (cmp < 0) return search(key, a, mid + 1, hi);
        else {
            // Found the key, now find the smallest index
            while (mid > lo && a[mid - 1].compareTo(key) == 0) mid--;
            return mid;
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            int result = search(key, a);
            if (result < 0) {
                StdOut.println(key + " not found, would be inserted at index " + (-result));
            } else {
                StdOut.println(key + " found at index " + result);
            }
        }
    }
}
