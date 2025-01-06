public class app2114 {
    public static int fd(int n) {
        int product = 2 * n;
        int sum = 0;
        int digit;
        while (product > 0) {
            digit = product % 10;
            product /= 10;
            sum += digit;
        }

        return sum;
    }

    public static int checksum(int n) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int digit = n % 10;
            n /= 10;
            if (i % 2 == 0) {
                sum += fd(digit);
            } else sum += digit;
        }
        return 10 - (sum % 10);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String result = args[0] + checksum(n);
        StdOut.println(result);
    }
}
