public class PolarCoordinates1226 {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double theta = Math.atan2(y, x);
        double r = x / Math.cos(theta);
        System.out.println("Polar coordinates = " + "(" + r + "," + Math.toDegrees(theta) + " degrees)");
    }
}
