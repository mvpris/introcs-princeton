public class Interval {
    private final double minimum;
    private final double maximum;

    public Interval(double min, double max) {
        if (max < min) throw new IllegalArgumentException("Interval is empty.");
        minimum = min;
        maximum = max;
    }

    public boolean contains(double x) {
        return x >= minimum && x <= maximum;
    }

    public boolean intersects(Interval b) {
        return maximum >= b.minimum && minimum <= b.maximum;
    }

    public String toString() {
        return "[" + minimum + "," + maximum + "]";
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        In in = new In();
        while (!in.isEmpty()) {
            double min = in.readDouble();
            double max = in.readDouble();
            Interval interval = new Interval(min, max);
            if (interval.contains(x)) System.out.println(interval);
        }
    }
}
