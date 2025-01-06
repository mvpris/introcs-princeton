public class app152 {
    public static void main(String[] args) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            if (n < 0) StdOut.println("Value is negative. Please type a positive value.");
            else {
                if (n < min) min = n;
                if (n > max) max = n;
            }
        }
        StdOut.println("min=" + min);
        StdOut.println("max=" + max);
    }
}
