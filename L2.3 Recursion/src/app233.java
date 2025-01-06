public class app233 {
    public static void ex233(int n) {
        if (n <= 0) return;
        StdOut.println(n);
        ex233(n - 2);
        ex233(n - 3);
        StdOut.println(n);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ex233(n);
    }
}
