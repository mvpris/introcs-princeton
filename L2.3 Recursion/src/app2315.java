public class app2315 {
    public static int binary(int n) {
        if (n == 0) return 0;
        return (n % 2 + 10 * binary(n / 2));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.print(binary(n));
//        while (n > 0) {
//            StdOut.print(n % 2);
//            n /= 2;
//        }
        StdOut.println();
    }
}
