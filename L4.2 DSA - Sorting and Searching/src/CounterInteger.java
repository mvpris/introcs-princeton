public class CounterInteger implements Comparable<CounterInteger> {
    private final Integer name;
    private final int maxCount;
    private int count;

    public CounterInteger(Integer id, int max) {
        if (max < 0) throw new IllegalArgumentException("Max value is negative.");
        name = id;
        maxCount = max;
    }

    public void increment() {
        if (count < maxCount) count++;
        assert count >= 0 : "Negative count detected in increment()";
    }

    public Integer name() {
        return name;
    }

    public int value() {
        return count;
    }

    public String toString() {
        return name + ": " + count;
    }

    @Override
    public int compareTo(CounterInteger that) {
        return Integer.compare(this.count, that.count);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        CounterInteger[] hits = new CounterInteger[n];
        for (int i = 0; i < n; i++)
            hits[i] = new CounterInteger(i, trials);
        for (int t = 0; t < trials; t++)
            hits[StdRandom.uniformInt(n)].increment();
        for (int i = 0; i < n; i++)
            StdOut.println(hits[i]);
    }
}
