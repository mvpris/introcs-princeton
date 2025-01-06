public class app1512 {
    public static void main(String[] args) {

        String[] a = StdIn.readAllStrings();
        int n = a.length;
        int nw = a.length / 3;
        String[] strings = new String[n];
        int[] ints1 = new int[n];
        int[] ints2 = new int[n];
        double[] doubles = new double[n];
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                strings[i / 3] = a[i];
            }
            if (i % 3 == 1) {
                ints1[i / 3] = Integer.parseInt(a[i]);
            }
            if (i % 3 == 2) {
                ints2[i / 3] = Integer.parseInt(a[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            doubles[i] = (double) ints1[i] / ints2[i];
        }

        StdOut.print("Word\tints1\tints2\tdoubles\n");
//        StdOut.printf("%s\t%d\t", strings[0], ints1[0]);
        for (int i = 0; i < nw; i++) {
            StdOut.printf("%s\t%d\t%d\t%.3f\n", strings[i], ints1[i], ints2[i], doubles[i]);
        }

    }
}
