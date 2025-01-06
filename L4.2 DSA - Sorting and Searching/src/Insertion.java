public class Insertion {
    public static <T extends Comparable<T>> void sort(T[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++)
            for (int j = i; j > 0; j--)
                if (a[j].compareTo(a[j - 1]) < 0)
                    exchange(a, j - 1, j);
                else break;
    }

    public static <T extends Comparable<T>> void sortSubArray(T[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            for (int j = i; j > lo; j--)
                if (a[j].compareTo(a[j - 1]) < 0)
                    exchange(a, j - 1, j);
                else break;
    }

    public static <T> void exchange(T[] a, int i, int j) {
        T temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        for (String s : a) StdOut.print(s + " ");
        StdOut.println();
    }
}
