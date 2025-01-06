public class Program1416 {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

//        Calculate primes using Sieve of Eratosthenes algorithm
        boolean[] prime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

//        Create relatively prime boolean array a
        boolean[][] a = new boolean[n][n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int gcd = 1;
                for (int k = 2; k < Math.min(i, j); k++) {
                    if (prime[k] && i % k == 0 && j % k == 0) {
                        gcd = k;
                        break;
                    }
                }
                a[i - 1][j - 1] = gcd == 1;
            }
        }


//        Print the contents of the array
//        Print column indices
        System.out.print("  ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

//        Print the rest of the array
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", i);
            System.out.print(" ");
            for (int j = 1; j <= n; j++) {
                if (a[i - 1][j - 1]) System.out.print("*  ");
                else System.out.print("   ");
            }
            System.out.println();
        }
    }
}
