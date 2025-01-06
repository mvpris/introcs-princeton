public class BinarySearchInt {
    public static int search(int key, int[] a) {
        return search(key, a, 0, a.length);
    }

    public static int search(int key, int[] a, int lo, int hi) {
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo) / 2;

        if (a[mid] == key) return mid;
        else if (a[mid] > key) return search(key, a, lo, mid);
        else return search(key, a, mid + 1, hi);

    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 8, 12, 24, 32};
        int key = Integer.parseInt(args[0]);
        int index = search(key, a);
        StdOut.println("index=" + index);
    }
}
