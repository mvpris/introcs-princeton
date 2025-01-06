public class app4128 {
    public static int countTriples(int[] a) { // Count triples that sum to 0.
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        count++;
        return count;
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        int count = countTriples(a);
        StdOut.println(count);
        int n = a.length;
        double probability = 1.0 - (double) count / n;
        StdOut.println("Probability that no triples sum to zero is = " + probability);
        // extra credit: approx formula is p=(1-1/2^32)-(n*(n-1)*(n-2))/6
    }
}
