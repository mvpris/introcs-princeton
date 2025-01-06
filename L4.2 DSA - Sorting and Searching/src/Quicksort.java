public class Quicksort {
    public static <T extends Comparable<T>> void sort(T[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array is not valid.");
        }
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        T pivot = a[lo];

        while (true) {
            while (a[++i].compareTo(pivot) < 0) if (i == hi) break;
            while (a[--j].compareTo(pivot) > 0) if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);

        return j;
    }

    public static <T extends Comparable<T>> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T extends Comparable<T>> void printT(T[] a) {
        for (T element : a) StdOut.print(element + " ");
        StdOut.println();
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {6, 1, 4, 7, 2, 5, 3};
        StdOut.print("Unsorted array: ");
        printT(a);
        sort(a);
        assert isSorted(a);
        StdOut.print("Sorted array:   ");
        printT(a);
    }
}
