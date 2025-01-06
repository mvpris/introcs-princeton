public class app4226 {
    public static void sort(double[] a) {
        double[] aux = new double[a.length];
        sort(a, aux, 0, a.length);
    }

    public static void sort(double[] a, double[] aux, int lo, int hi) {
        if (hi - lo <= 1) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);

        int i = lo, j = mid;

        for (int k = lo; k < hi; k++) {
            if (i == mid) aux[k] = a[j++];
            else if (j == hi) aux[k] = a[i++];
            else if (a[j] < a[i]) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
        for (int k = lo; k < hi; k++) {
            a[k] = aux[k];
        }
    }

    public static void findClosestPair(double[] a) {
        double min = Double.MAX_VALUE;
        double i = 0, j = 0;

        for (int k = 0; k < a.length - 1; k++) {
            double diff = Math.abs(a[k + 1] - a[k]);
            if (diff < min) {
                min = diff;
                i = a[k];
                j = a[k + 1];
            }
        }

        StdOut.println("Closest pair=" + i + "," + j);
    }

    public static void main(String[] args) {
        double[] a = {5, 2, 4, 7, 12, 9, 33, 22};
//        double[] aSorted = {2, 4, 5, 7, 9, 12, 22, 33};
        sort(a);
        for (double d : a) StdOut.print(d + " ");
        StdOut.println();
        findClosestPair(a);
    }
}
