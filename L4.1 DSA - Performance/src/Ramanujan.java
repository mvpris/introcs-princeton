public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        int distinct = 0;
        for (long i = 1; i < Math.cbrt(n); i++) {
            double b = Math.cbrt(n - i * i * i);
            if (Math.floor(b) == b) {
                if (count == 0) {
                    distinct = (int) b;
                    count++;
                } else if (i != distinct) count++;
                if (count == 2) return true;
            }
        }
        return false;
    }


    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
