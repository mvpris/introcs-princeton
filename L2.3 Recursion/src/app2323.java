public class app2323 {
    public static int getIndex(int[] a, int n) {
        int mi, i;
        for (mi = 0, i = 0; i < n; i++) {
            if (a[i] > a[mi]) {
                mi = i;
            }
        }

        return mi;
    }

    public static void iterativeReverse(int[] a, int i) {
        int temp, start = 0;
        while (start < i) {
            temp = a[start];
            a[start] = a[i];
            a[i] = temp;
            start++;
            i--;
        }
    }

    public static void recursiveReverse(int[] a, int left, int right) {
        if (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            recursiveReverse(a, left + 1, right - 1);
        }
    }

    public static void pancakeSort(int[] a, int n) {
        // Base case: If the array is already sorted or has
        // only one element, return
        if (n == 1) return;

        // Find index of the
        // maximum element in
        // a[0..curr_size-1]
        int mi = getIndex(a, n);

        // Move the maximum element to the front of the
        // array if it's not already there
        if (mi != 0) {
            recursiveReverse(a, 0, mi);
        }

        // Flip the entire array to move the maximum element
        // to its correct position
        recursiveReverse(a, 0, n - 1);

        // Recursively sort the remaining unsorted portion
        // of the array
        pancakeSort(a, n - 1);

    }

    public static void pancakeSortOld(int[] a, int n) {
        if (n > 1) {
            int mi = getIndex(a, n);
            if (mi != 0) {
                recursiveReverse(a, 0, mi);
            }
            recursiveReverse(a, 0, n - 1);
            pancakeSortOld(a, n - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] b = {2, 3, 5, 1, 4};
        int[] c = {2, 4, 3, 1};
        int[] d = {1, 1, -1, 1};
        pancakeSort(a, a.length);
        pancakeSort(b, b.length);
        pancakeSortOld(c, c.length);
        pancakeSort(d, d.length);
        StdArrayIO.print(a);
        StdArrayIO.print(b);
        StdArrayIO.print(c);
        StdArrayIO.print(d);
    }
}
