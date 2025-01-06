public class app2126 {
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
        int n = Integer.parseInt(args[0]);
        int[] p = primeFactorisation(n);
        int result = eulerTotient(n, p);
        StdOut.println(result);
    }
}
