public class app232 {
    public static double lnFactorial(int n) {
        if (n == 0 || n == 1) return 0;
        return Math.log(n) + lnFactorial(n - 1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(lnFactorial(n));
    }
}
