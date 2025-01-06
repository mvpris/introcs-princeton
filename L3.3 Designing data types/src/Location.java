public class Location {
    private final double latitude;
    private final double longitude;

    public Location(String location) {
        String[] loc1 = location.split(" ");
        loc1[1] = loc1[1].substring(0, 1);
        if (loc1[1].equals("S")) latitude = Math.toRadians(-Double.parseDouble(loc1[0]));
        else latitude = Math.toRadians(Double.parseDouble(loc1[0]));
        if (loc1[3].equals("E")) longitude = Math.toRadians(-Double.parseDouble(loc1[2]));
        else longitude = Math.toRadians(Double.parseDouble(loc1[2]));
    }

    public double distanceTo(Location b) {
        double sin = Math.sin(latitude) * Math.sin(b.latitude);
        double cos = Math.cos(latitude) * Math.cos(b.latitude);
        return 60.0 * Math.toDegrees(Math.acos(sin + cos * Math.cos(longitude - b.longitude)));
    }

    public static Location randomLocation() {
        double rlat1 = StdRandom.uniformDouble(0, 180);
        boolean rlat2b = StdRandom.bernoulli();
        String rlat2;
        if (!rlat2b) {
            rlat2 = "S";
            rlat1 = -rlat1;
        } else rlat2 = "N";

        double rlong1 = StdRandom.uniformDouble(0, 180);
        boolean rlong2b = StdRandom.bernoulli();
        String rlong2;
        if (!rlong2b) {
            rlong2 = "E";
            rlong1 = -rlong1;
        } else rlong2 = "W";

        String location = rlat1 + " " + rlat2 + ", " + rlong1 + " " + rlong2;
        return new Location(location);
    }

    public static void main(String[] args) {
        String location1 = args[0];
//        String location2 = args[1];
        Location point1 = new Location(location1);
//        Location point2 = new Location(location2);
        Location point2 = randomLocation();
        double d = point1.distanceTo(point2);
        System.out.println("d=" + d);

//       San Francisco "37.7749 N, 122.4194 W"
//       London "51.5072 N, 0.1276 W"
//       Sydney "33.8688 S, 151.2093 E"

    }
}
