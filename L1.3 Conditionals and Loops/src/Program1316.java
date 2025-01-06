public class Program1316 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n < 0) System.out.println("n is a negative power.");
        else for (int i = 0; i <= n; i++) {
            double power = Math.pow(2, i);
            System.out.println(power);
        }
    }
}
