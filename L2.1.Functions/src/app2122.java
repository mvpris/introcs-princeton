public class app2122 {
    public static boolean any(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i]) return true;
        }

        return false;
    }

    public static boolean all(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            if (!a[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean[] a = {false, false, false, false};
        boolean[] b = {false, true, false, false};
        boolean[] c = {true, true, true, true};
        StdOut.println(any(a));
        StdOut.println(all(a));
        StdOut.println(any(b));
        StdOut.println(all(b));
        StdOut.println(any(c));
        StdOut.println(all(c));
    }
}
