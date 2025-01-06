public class app2111 {
    public static int signum(int n) {
        return Integer.compare(n, 0);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(signum(n));
    }
}
