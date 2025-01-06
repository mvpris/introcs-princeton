public class app214 {
    public static boolean eq(int[] a, int[] b) {
        boolean length = a.length == b.length;
        if (length) {
            for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 9};
        StdOut.println(eq(a, b));
    }
}
