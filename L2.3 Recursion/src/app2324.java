public class app2324 {
    // append reverse of order n gray code to prefix string, and print
    public static void yarg(int n, String prefix) {
        if (n == 0) StdOut.println(prefix);
        else {
            gray(n - 1, prefix + "1");
            yarg(n - 1, prefix + "0");
        }
    }

    // append order n gray code to end of prefix string, and print
    public static void gray(int n, String prefix) {
        if (n == 0) StdOut.println(prefix);
        else {
            gray(n - 1, prefix + "0");
            yarg(n - 1, prefix + "1");
        }
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        gray(n, "");
    }

}
