import java.math.BigInteger;

public class app4135 {
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static int longestRunOfNines(String s) {
        int currentRun = 0, longestRun = 0;
        for (char c : s.toCharArray()) {
            if (c == '9') {
                currentRun++;
                longestRun = Math.max(longestRun, currentRun);
            } else {
                currentRun = 0;
            }
        }
        return longestRun;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        BigInteger factorialResult = factorial(n);
        StdOut.println(factorialResult.toString());
        int longestRun = longestRunOfNines(factorialResult.toString());
        StdOut.println("The longest run of consecutive 9s in " + n + "! is " + longestRun);
    }
}
