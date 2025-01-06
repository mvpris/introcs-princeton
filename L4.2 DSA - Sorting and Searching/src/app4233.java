public class app4233 {
    public static <T extends Comparable<T>> void sort(T[] a) {
        if (a == null || a.length == 0) return;
//            throw new IllegalArgumentException("Array is not valid.");

        T smaller = a[0];
        T larger = null;

//         Identify the two distinct values
        for (T value : a)
            if (value.compareTo(smaller) != 0) {
                larger = value;
                break;
            }

        if (larger == null) return;
//            throw new IllegalArgumentException("Array has only one value.");

//        Swap for ascending order
        if (larger.compareTo(smaller) < 0) {
            T temp = larger;
            larger = smaller;
            smaller = temp;
        }

        int left = 0, right = a.length - 1;
        while (left <= right) {
            while (left <= right && a[left].compareTo(smaller) == 0) left++;
            while (left <= right && a[right].compareTo(larger) == 0) right--;
            if (left < right) {
//                Swap elements
                swap(a, left, right);
                left++;
                right--;
            }
        }
    }

    public static <T extends Comparable<T>> void swap(T[] a, int left, int right) {
        T temp = a[right];
        a[right] = a[left];
        a[left] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {2, 1, 2, 1, 1, 2, 1, 2};
        sort(a);
        for (int num : a) StdOut.print(num + " ");
        StdOut.println();
    }
}
