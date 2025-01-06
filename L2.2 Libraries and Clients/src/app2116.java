public class app2116 {
    public static double max(double[] a) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < a.length; i++)
            if (a[i] > max) max = a[i];
        return max;
    }

    public static double min(double[] a) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < a.length; i++)
            if (a[i] < min) min = a[i];
        return min;
    }

    public static void scale(double[] a) {
        double min = min(a);
        double max = max(a);
        double diff = max - min;
        for (int i = 0; i < a.length; i++) {
            a[i] = (a[i] - min) / diff;
        }
    }

    public static void main(String[] args) {
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20};
        scale(a);
        for (double i : a) StdOut.printf("%.3f ", i);
        StdOut.println();
    }
}
