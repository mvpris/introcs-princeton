public class Clock {
    // Creates a clock whose initial time is hour hours and min minutes.
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    private int hour;
    private int min;

    public Clock(int h, int m) {
        if (h < 0 || h >= HOURS_PER_DAY) throw new IllegalArgumentException("Hours out of range");
        if (m < 0 || m >= MINUTES_PER_HOUR) throw new IllegalArgumentException("Minutes out of range");
        this.hour = h;
        this.min = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (!s.contains(":")) throw new IllegalArgumentException();
        int i = s.indexOf(':');
        String shour = s.substring(0, i);
        String smin = s.substring(i + 1);
        if (shour.length() != 2 || smin.length() != 2) throw new IllegalArgumentException();
        hour = Integer.parseInt(shour);
        min = Integer.parseInt(smin);
        if (hour < 0 || hour >= HOURS_PER_DAY || min < 0 || min >= MINUTES_PER_HOUR)
            throw new IllegalArgumentException();
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        if (hour < 10 && min < 10) return "0" + hour + ":" + "0" + min;
        else if (hour < 10) return "0" + hour + ":" + min;
        else if (min < 10) return hour + ":0" + min;
        else return hour + ":" + min;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour) return true;
        else return hour == that.hour && min < that.min;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        min++;
        if (min == MINUTES_PER_HOUR) {
            min = 0;
            hour++;
            if (hour == HOURS_PER_DAY) hour = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException();
        int minRepresentation = hour * MINUTES_PER_HOUR + min;
        minRepresentation += delta;
        int newHour = minRepresentation / MINUTES_PER_HOUR;
        int newMin = minRepresentation - MINUTES_PER_HOUR * newHour;
        hour = newHour % HOURS_PER_DAY;
        min = newMin % MINUTES_PER_HOUR;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock userTime = new Clock(23, 55);
        Clock otherTime = new Clock("08:45");
        StdOut.println(userTime.toString());
        userTime.tic();
        StdOut.println(userTime.toString());
        userTime.toc(15);
        StdOut.println(userTime.toString());
        StdOut.println(userTime.isEarlierThan(otherTime));
        StdOut.println(otherTime.toString());
        otherTime.toc(1441);
        StdOut.println(otherTime.toString());
    }
}
