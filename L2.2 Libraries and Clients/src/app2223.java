public class app2223 {
//        API
//
//        boolean isPrime ( int n)                  determines if an integer is prime
//        boolean relativelyPrime(int a, int b)     determines if two integers are relatively prime
//        int[] factors(int n)                      computes all factors of an integer
//        int gcd(int a, int b)                     computes the greatest common divisor of two integers
//        int lcm(int a, int b)                     computes the least common multiple of two integers
//        int[] primeFactorisation(int n)           computes the prime factorisation of an integer
//        int eulerTotient(int n, int[] p)          computes the euler totient function of an integer

    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static boolean relativelyPrime(int a, int b) {
        int limit = Math.min(a, b);

        for (int i = 2; i <= limit; i++) {
            if (a % i == 0 && b % i == 0) return false;
        }

        return true;
    }

    public static int[] factors(int n) {
        int[] f = new int[n];
        int index = 0;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) f[index++] = i;
        }

        int[] result = new int[index + 1];
        System.arraycopy(f, 0, result, 0, index);
        result[index] = n;

        return result;
    }

    public static int gcd(int a, int b) {
        int temp;
        while (b != 0) {
            if (a < b) {
                temp = a;
                a = b;
                b = temp;
            }
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int a1 = Math.abs(a);
        int b1 = Math.abs(b);
        int max = Math.max(a1, b1);
        int min = Math.min(a1, b1);
        int lcm = max;
        while (lcm % min != 0) {
            lcm += max;
        }
        return lcm;
    }

    public static int[] primeFactorisation(int n) {
        int[] primeFactors = new int[n];
        int index = 0;

        while (n % 2 == 0) {
            primeFactors[index++] = 2;
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primeFactors[index++] = i;
                n /= i;
            }
        }

        if (n > 2) primeFactors[index++] = n;

        int[] result = new int[index];
        System.arraycopy(primeFactors, 0, result, 0, index);

        return result;
    }

    public static int eulerTotient(int n, int[] p) {
        double product = 1;
        product *= (1 - 1.0 / p[0]);
        for (int i = 1; i < p.length; i++) {
            if (p[i] != p[i - 1]) {
                product *= (1 - 1.0 / p[i]);
            }
        }
        return (int) (n * product);
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("a = " + a + " b = " + b);
        StdOut.println("isPrime(a) = " + isPrime(a));
        StdOut.println("relativelyPrime(a,b) = " + relativelyPrime(a, b));
        StdOut.println("factors(a) = ");
        StdArrayIO.print(factors(a));
        StdOut.println("gcd(a, b) = " + gcd(a, b));
        StdOut.println("lcm(a, b) = " + lcm(a, b));
        StdOut.println("eulerTotient(a,primeFactorisation(a)) = " + eulerTotient(a, primeFactorisation(a)));
    }
}
