public class app421 {
    public static int binarySearch(int lo, int hi) {
        if (hi - lo == 1) return lo;
        int mid = lo + (hi - lo) / 2;
        StdOut.print("Greater or equal than " + mid + "?   ");
        if (StdIn.readBoolean()) return binarySearch(mid, hi);
        else return binarySearch(lo, mid);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println("Think of a number between 0 and " + (n - 1));
        int guess = binarySearch(0, n);
        StdOut.println("Your number is " + guess);
    }
}
