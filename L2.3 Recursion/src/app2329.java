public class app2329 {
    public static int collatz(int n) {
        StdOut.println(n + " ");
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else if (n % 2 == 0) {
            return collatz(n / 2);
        } else {
            return collatz(3 * n + 1);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(collatz(n));
    }

//  java app2329 7 | java app2329count
}
