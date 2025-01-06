public class app234 {
    public static String ex234(int n) {
        if (n <= 0) return "";
        return ex234(n - 3) + n + ex234(n - 2) + n;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(ex234(n));
    }
}
