import java.util.Objects;

public class Time {
    private final int hour;
    private final int minute;
    private final int second;

    public Time(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24)
            throw new RuntimeException("Hour is not valid.");
        if (minute < 0 || minute >= 60)
            throw new RuntimeException("Minute is not valid.");
        if (second < 0 || second >= 60)
            throw new RuntimeException("Second is not valid.");
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return String.format("%2d:%2d:%2d", getHour(), getMinute(), getSecond());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Time that = (Time) obj;
        return this.hour == that.hour && this.minute == that.minute && this.second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }

    public static void main(String[] args) {
        int hour = Integer.parseInt(args[0]);
        int minute = Integer.parseInt(args[1]);
        int second = Integer.parseInt(args[2]);
        Time time = new Time(hour, minute, second);
        System.out.println("Current time is: " + time);
    }
}
