public class app4225 {
    public static int findMax(int[] a, int lo, int hi) {
        if (lo == hi) return lo;
        int mid = lo + (hi - lo) / 2;

        if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) return mid;
        if (a[mid] < a[mid + 1]) return findMax(a, mid + 1, hi);
        return findMax(a, lo, mid - 1);
    }

    public static int binarySearch(int key, int[] a, int lo, int hi, boolean ascending) {
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo) / 2;

        if (a[mid] == key) return mid;
        else if (ascending) {
            if (a[mid] > key) return binarySearch(key, a, lo, mid, true);
            return binarySearch(key, a, mid + 1, hi, true);
        } else {
            if (a[mid] < key) return binarySearch(key, a, lo, mid, false);
            return binarySearch(key, a, mid + 1, hi, false);
        }
    }

    public static int searchBitonic(int key, int[] a) {
        int maxIndex = findMax(a, 0, a.length - 1);
        int index = binarySearch(key, a, 0, maxIndex + 1, true);
        if (index != -1) return index;
        return binarySearch(key, a, maxIndex + 1, a.length, false);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 9, 12, 6, 3};
        int key = Integer.parseInt(args[0]);
        int index = searchBitonic(key, a);
        StdOut.println("index=" + index);
    }
}
