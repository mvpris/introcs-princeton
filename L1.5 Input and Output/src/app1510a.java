public class app1510a {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        for (int i = 0; i < n; i++) {
            int num = (int) (Math.random() * (m - 1));
            StdOut.print(num + " ");
        }
        StdOut.println();
    }
}
