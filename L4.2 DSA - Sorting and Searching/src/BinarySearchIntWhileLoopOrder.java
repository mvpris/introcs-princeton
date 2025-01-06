public class BinarySearchIntWhileLoopOrder {
    public static int search(int key, int[] a, boolean ascending) {
        return search(key, a, 0, a.length, ascending);
    }

    public static int search(int key, int[] a, int lo, int hi, boolean ascending) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key) return mid;

            if (ascending) {
                if (a[mid] < key) lo = mid + 1;
                else hi = mid;
            } else {
                if (a[mid] < key) hi = mid + 1;
                else lo = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 8, 12, 24, 32};
        int[] b = {32, 24, 12, 8, 5, 3, 2};
        int key = Integer.parseInt(args[0]);
        int indexAsc = search(key, a, true);
        int indexDsc = search(key, b, false);
        StdOut.println("indexAsc=" + indexAsc);
        StdOut.println("indexDsc=" + indexDsc);
    }
}

