public class Program1339b {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        int n = 10;
        double sum = 0.0;
        for (int i = 0; i <= n; i++) {
            int fac = 1;
            for (int j = 2; j <= 2 * i; j++) {
                fac *= j;
            }
            sum += (Math.pow(-1, i) * Math.pow(x, 2 * i)) / fac;
        }
        System.out.println("cos(" + x + ")=" + sum);
        System.out.println("Math.cos(" + x + ")=" + Math.cos(x));
    }
}
