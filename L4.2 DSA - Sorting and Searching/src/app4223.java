public class app4223 {
    public static <T extends Comparable<T>> int floor(T key, T[] a) {
        if (key.equals(a[0])) return 0;
        return BinarySearchT.search(key, a) - 1;
    }

    public static <T extends Comparable<T>> int ceiling(T key, T[] a) {
        if (key.equals(a[a.length - 1])) return a.length - 1;
        return BinarySearchT.search(key, a) + 1;
    }

    public static void main(String[] args) {
        int n = 7;
        Counter[] counts = new Counter[n];
        for (int i = 0; i < n; i++) {
            counts[i] = new Counter(String.format("%d", i), n);
            for (int j = 0; j < i; j++) counts[i].increment();
        }
        StdOut.println("id: value");
        for (Counter c : counts) StdOut.println(c);
        StdOut.println("floor(3)=" + floor(counts[3], counts));      // correct answer is 2
        StdOut.println("ceiling(4)=" + ceiling(counts[4], counts));  // correct answer is 5
    }
}
