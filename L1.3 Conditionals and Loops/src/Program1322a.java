public class Program1322a {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String s = "";
        int power = 1;
        while (power <= n / 2) power *= 2;
        while (power > 0) {
            if (n < power) {
                s = s + 0;
            } else {
                s = s + 1;
                n -= power;
            }
            power /= 2;
        }
        System.out.println(s);
    }
}
