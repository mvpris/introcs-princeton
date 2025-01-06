public class Program1327 {
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        for (long factor = 2; factor <= n / factor; factor++) {
            boolean flag = true;
            while (n % factor == 0) {
                n /= factor;
                if (flag) {
                    System.out.print(factor + " ");
                    flag = false;
                }
            }
        }
        if (n > 1) System.out.print(n);
        System.out.println();
    }
}
