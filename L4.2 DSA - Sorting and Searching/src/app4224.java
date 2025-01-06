public class app4224 {
    public static int findMax(int[] a, int lo, int hi) {
        if (lo == hi) return lo;
        int mid = lo + (hi - lo) / 2;

        if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) return mid;
        if (a[mid] < a[mid + 1]) return findMax(a, mid + 1, hi);
        return findMax(a, lo, mid - 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 8, 12, 4, 2};
        int maxIndex = findMax(a, 0, a.length - 1);
        StdOut.println("maxIndex=" + maxIndex);
    }
}
