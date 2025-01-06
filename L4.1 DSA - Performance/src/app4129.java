public class app4129 {
    public static void printClosestPair(int[] a) {
        int n = a.length;
        int temp_i = 0, temp_j = 0;
        int close = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(a[i] - a[j]) < close) {
                    temp_i = i;
                    temp_j = j;
                    close = Math.abs(a[i] - a[j]);
                }
            }
        }
        StdOut.println(a[temp_i] + " " + a[temp_j]);
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        printClosestPair(a);
    }
}
