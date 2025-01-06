import java.util.Map;
import java.util.TreeMap;

public class app4447 {
    public static Map.Entry<Integer, Integer> findInterval(TreeMap<Integer, Integer> intervals, int query) {
        Map.Entry<Integer, Integer> interval = intervals.floorEntry(query);
        if (interval != null && query <= interval.getValue()) return interval;
        else return null;
    }

    public static void main(String[] args) {
        TreeMap<Integer, Integer> intervals = new TreeMap<>();

        intervals.put(1643, 2033);
        intervals.put(5532, 7643);
        intervals.put(8999, 10332);
        intervals.put(5666653, 5669321);

        int query = Integer.parseInt(args[0]);
        Map.Entry<Integer, Integer> interval = findInterval(intervals, query);
        if (interval != null)
            System.out.println("Query point " + query + " lies in the interval: " + interval.getKey() + "–" + interval.getValue());
        else
            System.out.println("Query point " + query + " lies in no interval.");
    }
}
