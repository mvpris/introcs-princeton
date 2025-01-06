public class Program1335 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int sum = 0;
        for (int i = 2; i <= 10; i++) {
            int digit = n % 10;
            sum = sum + i * digit;
            n /= 10;
        }
        System.out.print("The ful ISBN number is " + args[0]);
        if (sum % 11 == 1) System.out.println("X");
        else if (sum % 11 == 0) System.out.println("0");
        else System.out.println(11 - (sum % 11));
    }
}
