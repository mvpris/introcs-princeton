public class BinarySearchIntOrder {
    public static int search(int key, int[] a, boolean ascending) {
        return search(key, a, 0, a.length, ascending);
    }

    public static int search(int key, int[] a, int lo, int hi, boolean ascending) {
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo) / 2;

        if (a[mid] == key) return mid;
        else if (ascending) {
            if (a[mid] > key) return search(key, a, lo, mid, true);
            return search(key, a, mid + 1, hi, true);
        } else {
            if (a[mid] < key) return search(key, a, lo, mid, false);
            return search(key, a, mid + 1, hi, false);
        }
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
