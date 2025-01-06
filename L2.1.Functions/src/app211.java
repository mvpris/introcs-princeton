public class app211 {
    public static int max3(int n1, int n2, int n3) {
        int min = Integer.MAX_VALUE;
        if (n1 < min) min = n1;
        if (n2 < min) min = n2;
        if (n3 < min) min = n3;
        return min;
    }

    public static double max3(double n1, double n2, double n3) {
        double min = Double.MAX_VALUE;
        if (n1 < min) min = n1;
        if (n2 < min) min = n2;
        if (n3 < min) min = n3;
        return min;
    }

    public static void main(String[] args) {
        int i1 = (int) Double.parseDouble(args[0]);
        int i2 = (int) Double.parseDouble(args[1]);
        int i3 = (int) Double.parseDouble(args[2]);
        double d1 = Double.parseDouble(args[0]);
        double d2 = Double.parseDouble(args[1]);
        double d3 = Double.parseDouble(args[2]);
        StdOut.println(max3(i1, i2, i3));
        StdOut.println(max3(d1, d2, d3));
    }
}
