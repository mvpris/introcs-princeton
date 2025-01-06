public class Date {
    private static final int[] DaysOfMonths = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final int day;
    private final int month;
    private final int year;

    public Date(int d, int m, int y) {
        if (!isValid(d, m, y)) throw new RuntimeException("Invalid date.");
        day = d;
        month = m;
        year = y;
    }

    private static boolean isValid(int m, int d, int y) {
        if (d < 1 || d > DaysOfMonths[m]) return false;
        if (m < 1 || m > 12) return false;
        if (m == 2 && d == 29 && !isLeapYear(y)) return false;
        return true;
    }

    private static boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return (y % 4 == 0);
    }

    public Date next() {
        if (isValid(day + 1, month, year)) return new Date(day + 1, month, year);
        else if (isValid(day, month + 1, year)) return new Date(day, month + 1, year);
        else return new Date(day, month, year + 1);
    }

    public boolean isAfter(Date b) {
        return compareTo(b) > 0;
    }

    public boolean isBefore(Date b) {
        return compareTo(b) < 0;
    }

    public int compareTo(Date b) {
        if (year != b.year) return year - b.year;
        if (month != b.month) return month - b.month;
        return day - b.day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Date getDate() {
        return new Date(day, month, year);
    }

    public int DAY_OF_YEAR() {
        int sum = 0;
        for (int i = 1; i < month; i++) {
            sum += DaysOfMonths[i];
        }
        sum += day;
//        if (!isLeapYear(year)) return sum - 1;
//        return sum;
        if (month < 3) return sum;
        return sum - 1;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public static void main(String[] args) {
        Date today = new Date(1, 1, 1995);
        System.out.println(today);
        for (int i = 0; i < 10; i++) {
            today = today.next();
            System.out.println(today);
        }

        System.out.println(today.isAfter(today.next()));
        System.out.println(today.isAfter(today));
        System.out.println(today.next().isAfter(today));
    }
}
