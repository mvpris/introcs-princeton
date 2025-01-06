public class app2218 {
    public static double[] intervals(int n, double lo, double hi) {
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = lo + ((hi - lo) / n) * (i + 1);
        }

        return a;
    }

    public static double[] frequency(int n, double lo, double hi, double[] intervals, double[] values) {
        double[] freq = new double[n];
        int m = values.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (values[i] <= intervals[j] && values[i] > lo && values[i] < hi) {
                    freq[j]++;
                    break;
                }
            }
        }

        return freq;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        double[] intervals = intervals(n, lo, hi);
        double[] values = StdIn.readAllDoubles();
        double[] freq = frequency(n, lo, hi, intervals, values);

//        int p = 2;
//        double[] r = new double[p];
//        for (int i = 0; i < p; p++) {
//            r[i] = StdRandom.uniformDouble(lo, hi);
//        }
//        double[] freq2 = frequency(n, lo, hi, intervals, r);
//
        StdArrayIO.print(intervals);
        StdArrayIO.print(freq);
        StdDraw.setYscale(StdStats.min(freq), StdStats.max(freq));
        StdStats.plotBars(freq);
    }
}
