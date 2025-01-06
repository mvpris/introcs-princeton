public class app2332 {
    private static int c = 0;

    public static int mcCarthy(int n) {
        c++;
        StdOut.println(n);
        if (n > 100)
            return n - 10;
        return mcCarthy(mcCarthy(n + 11));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(mcCarthy(n));
        StdOut.println("calls count=" + c);
    }
}
