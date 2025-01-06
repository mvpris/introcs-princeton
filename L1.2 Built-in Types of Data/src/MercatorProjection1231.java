public class MercatorProjection1231 {
    public static void main(String[] args) {
        double lambda0 = Double.parseDouble(args[0]);
        double phi = Double.parseDouble(args[1]);
        double lambda = Double.parseDouble(args[2]);
        double x = lambda - lambda0;
        double y = 0.5 * Math.log((1 + Math.sin(phi)) / (1 - Math.sin(phi)));
        System.out.println("Rectangular coordinates=(" + x + "," + y + ")");
    }
}
