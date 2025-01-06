public class App151 {
    public static void main(String[] args) {
        int min = 0;
        int max = 0;
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            if (n < min) min = n;
            if (n > max) max = n;
        }
        StdOut.println(min);
        StdOut.println(max);
    }
}
