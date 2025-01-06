public class app2314website {
    public static void mystery(int n) {
        if (n == 0 || n == 1) return;
        mystery(n - 2);
        StdOut.println(n);
        mystery(n - 1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        mystery(n);
    }
}
