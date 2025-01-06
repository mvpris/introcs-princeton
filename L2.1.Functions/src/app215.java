public class app215 {
    public static boolean areTriangular(double a, double b, double c) {
        if (a >= b + c) return false;
        if (b >= a + c) return false;
        if (c >= a + b) return false;
        return true;
    }

    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        StdOut.println(areTriangular(a, b, c));
    }
}
