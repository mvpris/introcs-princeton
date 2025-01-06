public class app4234 {
    public static <T extends Comparable<T>> void sort(T[] a) {
        if (a == null || a.length == 0) return;

        T lowValue = a[0];
        T midValue = null;
        T highValue = null;

        for (T value : a)
            if (value.compareTo(lowValue) != 0) {
                if (midValue == null) midValue = value;
                else if (value.compareTo(midValue) != 0) {
                    highValue = value;
                    break;
                }
            }

        if (midValue == null || highValue == null) return;

        if (midValue.compareTo(lowValue) < 0) {
            T temp = midValue;
            midValue = lowValue;
            lowValue = temp;
        }
        if (highValue.compareTo(midValue) < 0) {
            T temp = highValue;
            highValue = midValue;
            midValue = temp;
        }
        if (midValue.compareTo(lowValue) < 0) {
            T temp = midValue;
            midValue = lowValue;
            lowValue = temp;
        }

        StdOut.println("lowValue = " + lowValue + " midValue = " + midValue + " highValue = " + highValue);
        StdOut.println();

        int low = 0, mid = 0, high = a.length - 1, countTrace = 1;

        StdOut.print("0: ");
        StdOut.print("low = " + low + " mid = " + mid + " high = " + high + "   ");
        printT(a);

        while (mid <= high) {
            if (a[mid].compareTo(lowValue) == 0) {
                swap(a, low, mid);
                low++;
                mid++;
            } else if (a[mid].compareTo(highValue) == 0) {
                swap(a, mid, high);
                high--;
            } else mid++;
            StdOut.print(countTrace + ": ");
            countTrace++;
            StdOut.print("low = " + low + " mid = " + mid + " high = " + high + "   ");
            printT(a);
        }
    }

    public static <T extends Comparable<T>> void swap(T[] a, int left, int right) {
        T temp = a[right];
        a[right] = a[left];
        a[left] = temp;
    }

    public static <T extends Comparable<T>> void printT(T[] a) {
        StdOut.print("{");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) StdOut.print(a[i]);
            else StdOut.print(a[i] + ", ");
        }
        StdOut.println("}");
    }

    public static void main(String[] args) {
//        Integer[] a = {2, 3, 1, 1, 2, 3, 2, 1, 1, 2, 3, 2};
        Integer[] a = {1, 2, 0, 1, 2, 0, 1, 2, 0};
        StdOut.print("Original array: ");
        printT(a);
        StdOut.println();
        sort(a);
    }
}
