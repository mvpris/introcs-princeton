public class app4139 {
    public static void main(String[] args) {
        // A sub-exponential function grows faster than any polynomial function but slower than any exponential function.
        // One common example is the superpolynomial function f(n)=2^(sqrt.n)

        int n = 10;

        int limit = (int) Math.pow(2, Math.sqrt(n));
        for (int i = 0; i < limit; i++) {
            // Simulate some work
            StdOut.println("Iteration = " + i);
        }

    }
}
