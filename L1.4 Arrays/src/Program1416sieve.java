public class Program1416sieve {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i <= n / i; i++) {
            for (int j = i; j <= n / i; j++) {
                prime[i * j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i]) System.out.print("*  ");
            else System.out.print("  ");
        }
        System.out.println();
    }
}
