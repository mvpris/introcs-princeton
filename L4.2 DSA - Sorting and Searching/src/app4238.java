public class app4238 {
    public static double[] cumulatedSums(double[] a) {
        double[] result = new double[a.length];
        result[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            result[i] = result[i - 1] + a[i];
        }
        return result;
    }

    public static int searchIndexIterative(double[] a, double r) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (r < a[mid]) hi = mid;
            else if (r > a[mid]) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public static int searchIndex(double[] a) {
        double r = StdRandom.uniformDouble(0, 1);
        StdOut.println("r=" + r);
        return searchIndex(a, r, 0, a.length);
    }

    public static int searchIndex(double[] a, double r, int lo, int hi) {
        if (hi <= lo) return lo;
        int mid = lo + (hi - lo) / 2;

        if (r < a[mid]) return searchIndex(a, r, lo, mid);
        else if (r > a[mid]) return searchIndex(a, r, mid + 1, hi);
        else return mid;
    }

    public static void main(String[] args) {
        double[] a = {0.1, 0.3, 0.2, 0.1, 0.005, 0.095, 0.1, 0.045, 0.055};
        StdArrayIO.print(a);
        double[] sum = cumulatedSums(a);
        StdArrayIO.print(sum);
        int i = searchIndex(sum);
        StdOut.println("i=" + i);
    }
}
