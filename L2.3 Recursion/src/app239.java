public class app239 {
    public static String ruler(int n) {
        if (n == 1) return "1";
        return ruler(n - 1) + " " + n + " " + ruler(n - 1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(ruler(n));
    }
}
