public class Program1321 {
    public static void main(String[] args) {
        long n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        String s = "";
        String sign = "";
        if (n < 0) {
            sign = "-";
            n *= -1;
        }
        while (n > 0) {
            int digit = (int) (n % k);
            n /= k;
            if (digit < 10) {
                s = digit + s;
            } else {
            /*    s = switch (digit) {
                    case 10 -> 'a';
                    case 11 -> 'b';
                    case 12 -> 'c';
                    case 13 -> 'd';
                    case 14 -> 'e';
                    default -> 'f';
                } + s;
             */
            }
        }
        System.out.println(sign + s);
    }
}
