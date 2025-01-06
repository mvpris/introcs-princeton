public class app238 {
    public static int mystery(int a, int b) {
        StdOut.println("a=" + a + " b=" + b);
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a * a, b / 2);
        return mystery(a * a, b / 2) * a;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println(mystery(a, b));
    }
}
