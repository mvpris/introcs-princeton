import java.util.Date;

public class app4446 {
    private final BST<String, Date> dates;

    public app4446() {
        dates = new BST<>();
    }

    public void insert(String dateName, Date date) {
        dates.put(dateName, date);
    }

    public Date search(String dateName) {
        return dates.get(dateName);
    }

    public int dateRangeCount(String loDate, String hiDate) {
        return dates.rangeCount(loDate, hiDate);
    }

    @Override
    public String toString() {
        return dates.toString();
    }

    public static void main(String[] args) {
        Date firstDate = new Date();
        firstDate.setTime(firstDate.getTime() - 7200000L);      // current startTime - 2h

        Date secondDate = new Date();
        secondDate.setTime(secondDate.getTime() - 3600000L);    // current startTime - 1h

        Date thirdDate = new Date();    // current startTime

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = dateFormat.format(currentDate);
//        StdOut.println("Formatted Date: " + formattedDate);

        app4446 calendar = new app4446();
        calendar.insert("First date", firstDate);
        calendar.insert("Second date", secondDate);
        calendar.insert("Third date", thirdDate);
        StdOut.println("Calendar: " + calendar);
        StdOut.println("First date: " + calendar.search("First date"));
        StdOut.println("Second date: " + calendar.search("Second date"));
        StdOut.println("Third date: " + calendar.search("Third date"));
        StdOut.println("The number of dates between the interval of \"First date\" and \"Third date\" is: " +
                calendar.dateRangeCount("First date", "Third date"));
    }
}
