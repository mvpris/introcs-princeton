public class app4126 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        byte[] isPrime = new byte[(n + 1) / 8 + 1];

        for (int i = 2; i <= n; i++)
            isPrime[i / 8] |= 1 << (i % 8);

        for (int i = 2; i <= n / i; i++) {
            if ((isPrime[i / 8] & (1 << (i % 8))) != 0) { // Mark multiples of i as nonprime.
                for (int j = i; j <= n / i; j++)
                    isPrime[i * j / 8] &= ~(1 << (i * j % 8));
            }
        }

        // Count the primes.
        int primes = 0;
        for (int i = 2; i <= n; i++)
            if ((isPrime[i / 8] & (1 << (i % 8))) != 0) primes++;
        System.out.println(primes);
    }
}
