public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) count++;
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        int c = 1;
        long x = k;

        if (k == ((long) n) * (n - 1) / 2) {
            for (int i = 0; i < n; i++) {
                a[i] = n - i - 1;
            }
            return a;
        }

        while (x >= ((long) n) - c) {
            a[c - 1] = n - c;
            x = x - n + c;
            c++;
        }

        int index = n - (int) x - 1;
        a[index] = n - c;
        for (int i = c - 1; i < index; i++) {
            a[i] = i - c + 1;
        }
        for (int i = index + 1; i < n; i++) {
            a[i] = i - c;
        }
        
        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] result = generate(n, k);
        for (int i : result) StdOut.print(i + " ");
        StdOut.println();
    }
}
