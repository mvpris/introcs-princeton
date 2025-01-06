public class DowJonesEntry {
    private final String date;
    private final double open;
    private final double high;
    private final double low;
    private final double close;
    private final double volume;
    private final double adjclose;

    public DowJonesEntry(String date, double open, double high, double low, double close, double volume, double adjclose) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.adjclose = adjclose;
    }

    public String getDate() {
        return date;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public double getVolume() {
        return volume;
    }

    public double getAdjClose() {
        return adjclose;
    }

    public String toString() {
        return date + "," + open + "," + high + "," + low + "," + close + "," + volume + "," + adjclose;
    }

    public static void main(String[] args) {
        DowJonesEntry entry = new DowJonesEntry("17-Mar-06", 11294.94, 11294.94, 11253.23, 11279.65, 2549619968d, 11279.65);
        System.out.println(entry);
    }
}
