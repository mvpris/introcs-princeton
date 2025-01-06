public class app426 {
    public static <T extends Comparable<T>> void sort(T[] a) {
        StdOut.printf("%8s", " ");
        printTrace(a);
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int lastj = 0;
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    exchange(a, j - 1, j);
                    lastj = j - 1;
                } else {
                    lastj = j;
                    break;
                }
            }
            StdOut.printf("i=%d j=%d ", i, lastj);
            printTrace(a);
        }
    }

    public static <T> void exchange(T[] a, int i, int j) {
        T temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static <T> void printTrace(T[] a) {
        for (T s : a) StdOut.printf("%3s ", s);
        StdOut.println();
    }


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        StdOut.printf("%8s", " ");
        printTrace(a);
    }
}
