public class app2117 {
    public static String[] reverse(String[] a) {
        String[] b = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length - i - 1];
        }

        return b;
    }

    public static void reverseInPlace(String[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            String temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        String[] a = {"a", "b", "c", "d", "e", "f"};
        String[] b = reverse(a);
        for (String i : b) StdOut.print(i + " ");
        StdOut.println();
        reverseInPlace(a);
        for (String i : a) StdOut.print(i + " ");
        StdOut.println();
    }
}
