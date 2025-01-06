import java.util.ArrayList;
import java.util.List;

// app4447 binary and sequential search on a sorted list implementation
public class NonOverlappingInterval {
    int start;
    int end;

    public NonOverlappingInterval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static NonOverlappingInterval findInterval(List<NonOverlappingInterval> intervals, int value) {
        for (NonOverlappingInterval interval : intervals) {
            if (value >= interval.start && value <= interval.end) return interval;
        }
        return null;
    }

    public static NonOverlappingInterval findIntergalBinarySearch(List<NonOverlappingInterval> intervals, int value) {
        int lo = 0;
        int hi = intervals.size();

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            NonOverlappingInterval midInterval = intervals.get(mid);

            if (value >= midInterval.start && value <= midInterval.end) return midInterval;
            else if (value < midInterval.start) hi = mid - 1;
            else lo = mid + 1;
        }
        return null;
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    }

    public static void main(String[] args) {
        List<NonOverlappingInterval> intervals = new ArrayList<>();
        intervals.add(new NonOverlappingInterval(1643, 2033));
        intervals.add(new NonOverlappingInterval(5532, 7643));
        intervals.add(new NonOverlappingInterval(8999, 10332));
        intervals.add(new NonOverlappingInterval(5666653, 5669321));
        int n = Integer.parseInt(args[0]);
        StdOut.println(findInterval(intervals, n));
        StdOut.println(findIntergalBinarySearch(intervals, n));
    }
}
