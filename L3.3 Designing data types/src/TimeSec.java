import java.util.Objects;

public class TimeSec {
    private final int secondsSinceMidnight;

    public TimeSec(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24)
            throw new RuntimeException("Hour is not valid.");
        if (minute < 0 || minute >= 60)
            throw new RuntimeException("Minute is not valid.");
        if (second < 0 || second >= 60)
            throw new RuntimeException("Second is not valid.");
        secondsSinceMidnight = hour * 3600 + minute * 60 + second;
    }

    public int getHour() {
        return secondsSinceMidnight / 3600;
    }

    public int getMinute() {
        return (secondsSinceMidnight % 3600) / 60;
    }

    public int getSecond() {
        return secondsSinceMidnight % 60;
    }

    @Override
    public String toString() {
        return String.format("%2d:%2d:%2d", getHour(), getMinute(), getSecond());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        TimeSec that = (TimeSec) obj;
        return this.secondsSinceMidnight == that.secondsSinceMidnight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondsSinceMidnight);
    }

    public static void main(String[] args) {
        int hour = Integer.parseInt(args[0]);
        int minute = Integer.parseInt(args[1]);
        int second = Integer.parseInt(args[2]);
        TimeSec time = new TimeSec(hour, minute, second);
        System.out.println("Current time is: " + time);

//        System.out.println(LocalDateTime.now());
    }
}
