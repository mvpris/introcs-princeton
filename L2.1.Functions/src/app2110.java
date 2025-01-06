public class app2110 {
    public static int lg(int n) {
        int result = 0;
        int powerOf2 = 1;
        while (powerOf2 * 2 <= n) {
            powerOf2 *= 2;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(lg(n));
    }
}
