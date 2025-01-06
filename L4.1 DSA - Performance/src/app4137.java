public class app4137 {
    public static void findMaxAverageSubarrayFixedLength(long[] a, int m) {
        int n = a.length;
        double maxAvg = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < n - m + 1; i++) {
            long sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += a[j];
                double avg = (double) sum / m;
                if (avg > maxAvg) {
                    maxAvg = avg;
                    start = i;
                    end = j;
                }
            }
        }
        StdOut.println("The subarray with the highest average is from index " + start + " to " + end +
                " with an average of " + maxAvg);
    }

    public static void findMaxAverageSubarray1(long[] a, int m) {
        int n = a.length;
        double maxAvg = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < n - 1; i++) {
            long sum = 0;
            for (int j = i; j < n && j < i + m; j++) {
                sum += a[j];
                double avg = (double) sum / (j - i + 1);
                if (avg > maxAvg) {
                    maxAvg = avg;
                    start = i;
                    end = j;
                }
            }
        }
        StdOut.println("The subarray with the highest average is from index " + start + " to " + end +
                " with an average of " + maxAvg);
    }

    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        int m = 4;
        findMaxAverageSubarrayFixedLength(arr, m);
//        findMaxAverageSubarray1(arr, m);
    }
}
