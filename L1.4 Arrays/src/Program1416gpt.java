public class Program1416gpt {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java RelativelyPrimeArray <n>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        boolean[][] a = new boolean[n][n];

        // Calculate primes using Sieve of Eratosthenes algorithm
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= n; i += p) {
                    primes[i] = false;
                }
            }
        }

        // Create the boolean array a
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int gcd = 1;
                for (int k = 2; k <= Math.min(i, j); k++) {
                    if (primes[k] && i % k == 0 && j % k == 0) {
                        gcd = k;
                        break;
                    }
                }
                a[i - 1][j - 1] = gcd == 1;
            }
        }

        // Print the contents of the array
        System.out.print("   ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", i);
            for (int j = 1; j <= n; j++) {
                System.out.print(a[i - 1][j - 1] ? "  * " : "    ");
            }
            System.out.println();
        }
    }
}
