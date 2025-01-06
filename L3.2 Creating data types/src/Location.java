public class Location {
    private final double latitude;
    private final double longitude;

    public Location(double lat, double lon) {
        latitude = Math.toRadians(lat);
        longitude = Math.toRadians(lon);
    }

    public double distanceTo(Location b) {
        double sin = Math.sin(latitude) * Math.sin(b.latitude);
        double cos = Math.cos(latitude) * Math.cos(b.latitude);
        return 60.0 * Math.toDegrees(Math.acos(sin + cos * Math.cos(longitude - b.longitude)));
    }

    public static void main(String[] args) {
        double lat1 = Double.parseDouble(args[0]);
        double lon1 = Double.parseDouble(args[1]);
        double lat2 = Double.parseDouble(args[2]);
        double lon2 = Double.parseDouble(args[3]);
        Location point1 = new Location(lat1, lon1);
        Location point2 = new Location(lat2, lon2);
        double d = point1.distanceTo(point2);
        System.out.println("d=" + d);
    }
}
