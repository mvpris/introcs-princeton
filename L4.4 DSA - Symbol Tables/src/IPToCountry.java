import java.util.Map;
import java.util.TreeMap;

public class IPToCountry {
    TreeMap<Long, String> ipMap;

    public IPToCountry() {
        ipMap = new TreeMap<>();
        loadCSVData();
    }

    private void loadCSVData() {
        StdIn.readLine();

        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] tokens = line.split(",");
            long startIP = Long.parseLong(tokens[2].replace("\"", ""));
            long endIP = Long.parseLong(tokens[3].replace("\"", ""));
            String country = tokens[5].replace("\"", "");
            ipMap.put(startIP, country);
            ipMap.put(endIP + 1, null);
        }
    }

    public String getCountry(String ipAddress) {
        long ipNumber = ipToLong(ipAddress);
        Map.Entry<Long, String> entry = ipMap.floorEntry(ipNumber);

        if (entry != null && entry.getValue() != null) {
            return entry.getValue();
        }
        return "Unknown";
    }

    private long ipToLong(String ipAddress) {
        String[] octets = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result |= Long.parseLong(octets[i]) << (24 - (8 * i));
        }
        return result;
    }

    public static void main(String[] args) {
        IPToCountry ipToCountry = new IPToCountry();
        String ipAddress1 = "0.0.0.0";
        String ipAddress2 = "4.2.145.63";
        String ipAddress3 = "4.2.145.64";
        String country1 = ipToCountry.getCountry(ipAddress1);
        String country2 = ipToCountry.getCountry(ipAddress2);
        String country3 = ipToCountry.getCountry(ipAddress3);
        StdOut.println("The IP address " + ipAddress1 + " is from " + country1);
        StdOut.println("The IP address " + ipAddress2 + " is from " + country2);
        StdOut.println("The IP address " + ipAddress3 + " is from " + country3);
    }
}
