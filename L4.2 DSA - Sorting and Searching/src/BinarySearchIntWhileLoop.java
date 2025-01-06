public class BinarySearchIntWhileLoop {
    public static int search(int key, int[] a) {
        return search(key, a, 0, a.length);
    }

    public static int search(int key, int[] a, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key) return mid;
            if (a[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 8, 12, 24, 32};
        int key = Integer.parseInt(args[0]);
        int index = search(key, a);
        StdOut.println("index=" + index);
    }
}
