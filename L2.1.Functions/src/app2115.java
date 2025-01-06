public class app2115 {
    public static double angle(double d1, double a1, double d2, double a2) {
        d1 = Math.toRadians(d1);
        a1 = Math.toRadians(a1);
        d2 = Math.toRadians(d1);
        a2 = Math.toRadians(a2);
        double d = d2 - d1;
        double a = a2 - a1;
        double sinSquaredD = Math.sin(d / 2) * Math.sin(d / 2);
        double sinSquaredA = Math.sin(a / 2) * Math.sin(a / 2);
        double cosD1 = Math.cos(d1);
        double cosD2 = Math.cos(d2);

        return 2 * Math.asin(Math.sqrt(sinSquaredD + cosD1 * cosD2 * sinSquaredA));
    }

    public static void main(String[] args) {
        double d1 = Double.parseDouble(args[0]);
        double a1 = Double.parseDouble(args[1]);
        double d2 = Double.parseDouble(args[2]);
        double a2 = Double.parseDouble(args[3]);
        StdOut.println(angle(d1, a1, d2, a2));
    }
}
