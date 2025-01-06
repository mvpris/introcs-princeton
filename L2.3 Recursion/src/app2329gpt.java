public class app2329gpt {
    private static final int MAX_N = 1000000; // Adjust the size based on the expected range of n
    private static final int[] previousResults = new int[MAX_N];

    private static int collatz(int n) {
        int result = 1;
        if (n >= 1 && n < MAX_N && previousResults[n] != 0) {
            return previousResults[n];
        } else {
            if (n == 1) {
                result = 1;
            } else if (n % 2 == 0) {
                result += collatz(n / 2);
            } else {
                result += collatz(3 * n + 1);
            }
            if (n >= 1 && n < MAX_N) {
                previousResults[n] = result;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int maxn = 0, maxSize = 0;

        for (int n = N; n > 0; n--) {
            int size = collatz(n);
            if (size > maxSize) {
                maxn = n;
                maxSize = size;
            }
        }

        System.out.println(maxn + " - " + maxSize);
    }
}
