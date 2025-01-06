public class app4227 {
    public static void findFurthestValue(double[] a) {
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        for (double d : a) {
            if (d < min) min = d;
            if (d > max) max = d;
        }
        StdOut.println("Furthest pair is=" + min + "," + max);
    }

    public static void main(String[] args) {
        double[] a = {5, 2, 4, 7, 12, 9, 33, 22};
        findFurthestValue(a);
    }
}
