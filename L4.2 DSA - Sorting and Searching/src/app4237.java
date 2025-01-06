public class app4237 {
    public static int findLocalMin(int[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        if ((mid == 0 || a[mid - 1] > a[mid]) && (mid == a.length - 1 || a[mid + 1] > a[mid])) return mid;
        else if (mid > 0 && a[mid - 1] < a[mid]) return findLocalMin(a, lo, mid - 1);
        else return findLocalMin(a, mid + 1, hi);
    }

    public static void main(String[] args) {
        int[] a = {9, 6, 3, 14, 5, 7, 4};
        int localMinIndex = findLocalMin(a, 0, a.length - 1);
        StdOut.println("Index if local minimum is=" + localMinIndex);
        StdOut.println("Local minimum value is=" + a[localMinIndex]);
    }
}
