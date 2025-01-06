public class app4131 {
    public static void main(String[] args) {
        // read in input data
        long[] a = StdIn.readAllLongs();
        int n = a.length;

        // number of subsets that sum to exactly 0
        int count = 0;
        for (int k = 1; k < (1 << n); k++) {
            long sum = 0;
            for (int i = 0; i < n; i++)
                if (((k >> i) & 1) == 1) sum = sum + a[i];
            if (sum == 0)
                count++;
        }
        StdOut.println(count);
        // time complexity is n*2^n;
    }
}
