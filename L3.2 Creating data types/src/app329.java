public class app329 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Interval[] intervals = new Interval[n];
        In in = new In();
        for (int i = 0; i < n; i++) {
            double min = in.readDouble();
            double max = in.readDouble();
            intervals[i] = new Interval(min, max);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.println(intervals[i]);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intervals[i].intersects(intervals[j]))
                    System.out.println(intervals[i] + " intersects " + intervals[j]);
            }
        }
    }
}
